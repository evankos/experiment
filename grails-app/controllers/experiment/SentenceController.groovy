package experiment
import grails.converters.JSON

import java.util.logging.Filter


//import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText
import static org.springframework.http.HttpStatus.NO_CONTENT

class SentenceController extends BaseController {
    static responseFormats = ['json']
    static allowedMethods = [index: "GET", save: 'POST', login: 'POST', out: 'GET', ibmCall: 'POST', results: 'POST']
    def fileService
    def index() {

        def currentIndex = session.getAttribute("index")
        def userData = session.getAttribute("data")

        def data = [
                sentence:userData["sentences"][currentIndex % userData["sentences"].size()],
                order: currentIndex<userData["orders"].size()*userData["sentences"].size()?userData["orders"][currentIndex.intdiv(userData["sentences"].size())]:"DONE",
                index: currentIndex % userData["sentences"].size()
        ]
        if(userData["orders"].size()*userData["sentences"].size()<=currentIndex){
            session.invalidate()
        }
        JSON.use('deep') {
            render data as JSON
        }
    }

//    def ibmCall(WatsonCommand watsonCommand){
//        if (watsonCommand.hasErrors()) {
//            handleValidationException(watsonCommand.errors)
//        }
//        println "ibmCall"
//        SpeechToText textService = new SpeechToText();
//
//        JSON.use('deep') {
//            render watsonCommand as JSON
//        }
//    }

    def login(LoginCommand loginCommand){
        if (loginCommand.hasErrors()) {
            handleValidationError(loginCommand.errors)
        }
        session["user"] = session.id //loginCommand.id
        session["userName"] = loginCommand.name
        session["data"] = fileService.getScrambledData()
        session["index"] = 0

        JSON.use('deep') {
            render loginCommand as JSON
        }
    }

    def out(){
        session.invalidate()
        render status: NO_CONTENT.value()
    }

    def save(SentenceCommand sentenceCommand){

        if (sentenceCommand.hasErrors()) {
            handleValidationError(sentenceCommand.errors)
        }

        session["index"] = session.getAttribute("index")+1
//        fileService.writeFile(session.getAttribute("user"),sentenceCommand)
        saveDB(sentenceCommand)
        index()
    }

    def results(FilterCommand filterCommand){
        def results = DataPoints.findAllByIdBetween(filterCommand.firstResult,filterCommand.firstResult+filterCommand.itemsPerPage)
        int dataCount = DataPoints.count()
        def data = [
                items:results,
                totalCount:dataCount
        ]
        JSON.use('deep') {
            render data as JSON
        }
    }

    private void saveDB(SentenceCommand sentenceCommand){
        new DataPoints(userID: session.getAttribute("user"),userName: session.getAttribute("userName"),solution: sentenceCommand.solution,
                sentence: sentenceCommand.sentence,time: sentenceCommand.time,instruction: sentenceCommand.order).save(flush: true)
    }
}

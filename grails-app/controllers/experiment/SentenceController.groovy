package experiment
import grails.converters.JSON


import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText


class SentenceController extends BaseController {
    static responseFormats = ['json']
    static allowedMethods = [index: "GET", save: 'POST', login: 'POST', ibmCall: 'POST']
    def fileService
    def index() {
//        def data = fileService.getSentencesScrambled()


        def currentIndex = session.getAttribute("index")
        def userData = session.getAttribute("data")

        def data = [
                sentence:userData["sentences"][currentIndex % userData["sentences"].size()],
                order: currentIndex<userData["orders"].size()*userData["sentences"].size()?userData["orders"][currentIndex.intdiv(userData["sentences"].size())]:"DONE"
        ]
        if(userData["orders"].size()*userData["sentences"].size()<=currentIndex){
            session.invalidate()
        }
        JSON.use('deep') {
            render data as JSON
        }
    }

    def ibmCall(WatsonCommand watsonCommand){
        if (watsonCommand.hasErrors()) {
            handleValidationException(watsonCommand.errors)
        }
        println "ibmCall"
        SpeechToText textService = new SpeechToText();

        JSON.use('deep') {
            render watsonCommand as JSON
        }
    }

    def login(LoginCommand loginCommand){
        if (loginCommand.hasErrors()) {
            handleValidationException(loginCommand.errors)
        }
        session["user"] = loginCommand.id
        session["userName"] = loginCommand.name
        session["data"] = fileService.getScrambledData()
        session["index"] = 0

        JSON.use('deep') {
            render loginCommand as JSON
        }
    }

    def save(SentenceCommand sentenceCommand){

        if (sentenceCommand.hasErrors()) {
            handleValidationException(sentenceCommand.errors)
        }
        else{
            session["index"] = session.getAttribute("index")+1
            fileService.writeFile(session.getAttribute("user"),sentenceCommand)
        }

        index()
    }
}

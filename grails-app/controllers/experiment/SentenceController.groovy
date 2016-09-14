package experiment
import grails.converters.JSON

class SentenceController extends BaseController {
    static responseFormats = ['json']
    static allowedMethods = [index: "GET", save: 'POST']
    def fileService
    def index() {
        print "EXECUTING"
        def data = fileService.getSentencesScrambled()
        JSON.use('deep') {
            render data as JSON
        }
    }
    def save(SentenceCommand sentenceCommand){
        println "Saving"
        if (sentenceCommand.hasErrors()) {
            handleValidationException(sentenceCommand.errors)
        }
        fileService.writeFile(sentenceCommand)
        JSON.use('deep') {
            render sentenceCommand as JSON
        }
    }
}

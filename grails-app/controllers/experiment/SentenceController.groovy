package experiment
import grails.converters.JSON

class SentenceController {
    static responseFormats = ['json']
    static allowedMethods = [index: "GET"]
    def fileService
    def index() {
        print "EXECUTING"
        def data = fileService.getSentencesScrambled()
        JSON.use('deep') {
            render data as JSON
        }
    }
}

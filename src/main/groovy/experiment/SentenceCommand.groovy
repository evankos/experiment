package experiment

/**
 * Created by Vaggelis on 9/14/2016.
 */
import grails.validation.Validateable



class SentenceCommand implements Validateable {

    String solution
    String sentence
    String order
    Long time
    static constraints = {
        sentence blank: false
    }
}

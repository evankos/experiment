package experiment

/**
 * Created by Vaggelis on 9/14/2016.
 */
import grails.validation.Validateable


class LoginCommand implements Validateable {
//    String id
    String name
    static constraints = {
        // this Date object is created when the constraints are evaluated, not
        // each time an instance of the User class is validated.
        name blank: false
    }
}

package experiment

/**
 * Created by Vaggelis on 9/14/2016.
 */
import grails.validation.Validateable


class LoginCommand implements Validateable {
    String id
    String name

}

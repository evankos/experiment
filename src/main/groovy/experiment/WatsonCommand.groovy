package experiment

/**
 * Created by Vaggelis on 9/14/2016.
 */
import grails.validation.Validateable

import java.sql.Blob


class WatsonCommand implements Validateable {
    String id
    String name
    byte[] payload
}

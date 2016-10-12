package experiment


import grails.validation.Validateable

/**
 * Created by Vaggelis on 10/12/2016.
 */
class FilterCommand implements Validateable{
    Integer firstResult
    Integer itemsPerPage
}

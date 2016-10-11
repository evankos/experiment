package experiment

import grails.converters.JSON
import grails.validation.ValidationErrors
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.BAD_REQUEST
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR


abstract class BaseController {

    def handleValidationError(ValidationErrors errors){
        errors.each{ error ->
            error.fieldErrors.each { fieldError ->
                errors << "${fieldError.defaultMessage}"
            }
        }
        errors << "Pass this code to technical support: 500"
        response.status = BAD_REQUEST.value()
        render errors as JSON
    }

    def handleValidationException(ValidationException ve){
        def errors = []
        def locale = Locale.getDefault()
        println "VALIDATION EXCEPTION"
        ve.errors.each{ error ->
            error.fieldErrors.each { fieldError ->
                errors << "${fieldError.defaultMessage}"
            }
        }
//        def logCode = logService.logWarning(ErrorCode.VALIDATION_EXCEPTION.code, ve)
        errors << "Pass this code to technical support: 500"
        response.status = BAD_REQUEST.value()
        render errors as JSON
    }


    def handleGenericException(Exception e){
        def errors = []
//        def logCode = logService.logError(ErrorCode.GENERIC_EXCEPTION.code, e)
        errors << "${e.message}"
        errors << "Pass this code to technical support: 500"
        response.status = INTERNAL_SERVER_ERROR.value()
        render errors as JSON
    }
}

package experiment

import grails.converters.JSON
import grails.converters.XML

class RootController {

    def index() {
        redirect(uri: '/experiment')
    }

    def serveApp() {
        redirect(uri: "/${params.appName ?: 'experiment'}/index")
    }

    def html5Redirect() {
        render(view: "/${params.appName}/index")
    }
}

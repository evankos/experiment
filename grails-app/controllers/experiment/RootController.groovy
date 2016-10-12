package experiment

import grails.converters.JSON
import grails.converters.XML

class RootController extends BaseController {

    def index() {
        redirect(uri: '/experiment')
    }

    def serveApp() {
        redirect(uri: "/${params.appName ?: 'experiment'}/index")
    }

    def html5Redirect() {
//        render(view: "/${params.appName}/index")
        redirect(uri: "/${params.appName}/pages/index")
//        session.getAttribute('user')?redirect(uri: "/experiment"):redirect(uri: "/login")
    }

    def servePage() {

        if(params.appName!='administration')
            session.getAttribute('user')?render(view: "/${params.appName}/proceding"):render(view: "/${params.appName}/login")
        else
            render(view: "/${params.appName}/index")
//        session.getAttribute('user')?render(view: "/${params.appName}/${params.pageName}"):render(view: "/${params.appName}/pages/login")

    }
}

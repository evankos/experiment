package experiment


class BaseInterceptor {
    BaseInterceptor(){
        matchAll().excludes(controller: 'exception', action: 'unsupportedBrowser').excludes (controller: 'sentence');
    }
    boolean before() {
        println "Tracing action ${request.requestURL}"
        if(!(request.getHeader("User-Agent").toLowerCase().contains('chrome') || request.getHeader("User-Agent").toLowerCase().contains('lumia'))){
            redirect controller: 'exception', action: 'unsupportedBrowser'
            false
        }else {
            true
        }
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}

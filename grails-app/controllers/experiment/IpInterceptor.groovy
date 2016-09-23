package experiment
import static org.springframework.http.HttpStatus.FORBIDDEN

class IpInterceptor {
    IpInterceptor(){
        matchAll()
    }
    boolean before() {
        def ips = getIpRegEx (grailsApplication.config)
        //213.124.162.152
        if (request.remoteAddr =~ ips) {
            return true
        }

        response.sendError (FORBIDDEN.value ())
        false
    }

    private String getIpRegEx (def config) {
        config.admin.ip.replaceAll  ('\\.', '\\\\.')
    }
    boolean after() { true }

    void afterView() {
        // no-op
    }
}

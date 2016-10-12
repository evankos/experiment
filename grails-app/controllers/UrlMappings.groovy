class UrlMappings {

    static mappings = {
        "/"(controller: 'root', action: 'index')

        "/exception/**"(controller: 'exception', action: 'unsupportedBrowser') {

        }
        ['experiment', 'administration'].each { name ->

            "/${name}"(controller: 'root', action: 'serveApp'){
                appName = name
            }

            // HTML5 Redirect
            "/${name}/**"(controller: 'root', action: 'html5Redirect') {
                appName = name
            }

            // Angular page route
            "/${name}/pages/${pageName}"(controller: 'root', action: 'servePage') {
                appName = name
            }

            // Angular partial templates route
            "/${name}/templates/${templateName}"(controller: 'root', action: 'serveTemplate') {
                appName = name
            }
        }

        "/api/sentences"(controller: 'sentence') {
            action = [GET: 'index', POST: 'save']
        }
//        "/api/watson"(controller: 'sentence') {
//            action = [POST: 'ibmCall']
//        }
        "/api/login"(controller: 'sentence') {
            action = [POST: 'login']
        }
        "/api/out"(controller: 'sentence') {
            action = [GET: 'out']
        }
        "/api/results"(controller: 'sentence') {
            action = [POST: 'results']
        }
        /**
         * ERRORS
         */
        "400"(controller: 'root', action: 'error')
        "401"(controller: 'root', action: 'error')
        "403"(controller: 'root', action: 'error')
        "404"(controller: 'root', action: 'error')
        "503"(controller: 'root', action: 'error')
        "500"(controller: 'root', action: 'error')
    }
}

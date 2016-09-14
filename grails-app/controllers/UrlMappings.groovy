class UrlMappings {

    static mappings = {
        "/"(controller: 'root', action: 'index')
//        "/$controller/$action?/$id?(.$format)?"{
//            constraints {
//                // apply constraints here
//            }
//        }

//        "/"(controller: "root") {
//            action = [GET: 'index']
//        }

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
            action = [GET: 'index']
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

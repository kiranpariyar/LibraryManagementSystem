class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"main")
        "/home"(controller:"main",action:"home")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}

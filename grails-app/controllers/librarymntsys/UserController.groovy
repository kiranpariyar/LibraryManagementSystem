package librarymntsys

class UserController {

    def loginHandle = {
        if (params.username == "kiran" && params.password == "kiran") {
            // username and password match -> log in
            session.user = "kiran"
            redirect(controller:'main',action: "home")
        } else {
            flash.message = "User not found"
            redirect(controller:'main',action: "login")
        }
    }

    def logout = {
        session.invalidate()
        redirect(controller:'main',action: "login")
    }

}

package librarymntsys

class MainController {

    def index() {
        render(view: "login.gsp")
    }

    def home(){
        render(view: "home.gsp")
    }

}

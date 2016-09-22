package experiment

class ExceptionController {

    def unsupportedBrowser(){
        render(view: "/exception/notSupported");
    }
}

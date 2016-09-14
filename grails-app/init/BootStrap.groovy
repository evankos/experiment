class BootStrap {
    def fileService
    def init = { servletContext ->
        fileService.init([
                'I have an Apple',
                'I have two Apples'
        ],['speak','write'].toList())
        println fileService.getSentencesScrambled()
    }
    def destroy = {
    }
}

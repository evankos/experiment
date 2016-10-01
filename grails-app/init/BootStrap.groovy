class BootStrap {
    def fileService
    def init = { servletContext ->
        fileService.init([
                'I have an Apple',
                'I have two Apples',
                'Because my coffee was too cold, I heated it in the microwave'
        ],['speak','type','swipe'].toList())
//        println fileService.getSentencesScrambled()
    }
    def destroy = {
    }
}

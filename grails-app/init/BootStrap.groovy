class BootStrap {
    def fileService
    def init = { servletContext ->
        fileService.init([
                1: ['I have an Apple','50'],
                2: ['I have twp Apples','50']
        ],['speak','write'].toList())
        println fileService.getSentencesScrambled()
    }
    def destroy = {
    }
}

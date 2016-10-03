class BootStrap {
    def fileService
    def init = { servletContext ->
        fileService.init(['the gun discharged by accident', 'get rid of that immediately',
                          'every apple from every tree', 'good at addition and subtraction',
                          'we accept personal checks', 'the generation gap gets wider',
                          'exceed the maximum speed limit', 'we went grocery shopping',
                          'superman never wore a mask', 'teaching services will help',
                          'you have my sympathy', 'I watched blazing saddles',
                          'elephants are afraid of mice', 'it is difficult to concentrate',
                          'the kids are very excited', 'my preferred treat is chocolate',
                          'the treasury department is broke', 'Valium in the economy size',
                          'the insulation is not working', 'the second largest country',
                          'he called seven times', 'the library is closed today',
                          'the acceptance speech was boring', 'quick there is someone knocking',
                          'the protesters blocked all traffic', 'seasoned golfers love the game',
                          'the aspirations of a nation', 'fall is my favorite season',
                          'prescription drugs require a note', 'well connected with people'],['speak','type','swipe'].toList())
//        println fileService.getSentencesScrambled()
    }
    def destroy = {
    }
}

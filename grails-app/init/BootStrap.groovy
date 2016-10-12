class BootStrap {
    def fileService
    def init = { servletContext ->
        fileService.init([
                'physics and chemistry are hard',
                'elephants are afraid of mice',
                'Valium in the economy size',
                'my preferred treat is chocolate',
                'we went grocery shopping',
                'the second largest country',
                'buckle up for safety',
                'the library is closed today',
                'teaching services will help',
                'we accept personal checks',
                'fall is my favorite season',
                'the kids are very excited',
                'limited warranty of two years',
                'get rid of that immediately',
                'I watched blazing saddles',
                'superman never wore a mask',
                'seasoned golfers love the game'
        ],['speak','type','swipe'].toList())
//        fileService.init([
//                'a most ridiculous thing',
//                'quick there is someone knocking',
//                'bad for the environment',
//                'the protesters blocked all traffic',
//                'the acceptance speech was boring',
//                'exceed the maximum speed limit',
//                'every apple from every tree',
//                'this system of taxation',
//                'the treasury department is broke',
//                'well connected with people',
//                'the generation gap gets wider',
//                'your etiquette needs some work',
//                'you have my sympathy',
//                'good at addition and subtraction',
//                'the aspirations of a nation',
//                'there are winners and losers',
//                'he called seven times',
//                'vote according to your conscience',
//                'the gun discharged by accident',
//                'these barracks are big enough',
//                'it is difficult to concentrate',
//                'the most beautiful sunset',
//                'prescription drugs require a note',
//                'the insulation is not working',
//                'the chancellor was very boring',
//                'the stock exchange dipped',
//                'parking tickets can be challenged',
//                'most judges are very honest',
//                'you are a capitalist pig',
//                'a steep learning curve in riding a unicycle'
//        ],['speak','type','swipe'].toList())
//        println fileService.getSentencesScrambled()
    }
    def destroy = {
    }
}

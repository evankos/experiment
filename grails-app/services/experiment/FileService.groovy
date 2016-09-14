package experiment

import grails.transaction.Transactional

@Transactional
class FileService {
    def sessionFactory
    def sentences = []
    def orders
    def sequence
    def init(sents,ords){
        println "Setting Sentences"
        sentences = sents
        orders = ords
//        for (def i = 1; i <= sents.size(); i++) {
//            sequence.push(i)
//        }
        sequence = (0 .. sents.size()-1).toList()
        println "Sequence"+sequence
    }
    def getSentencesScrambled() {
        println "Getting Sentences"

        Collections.shuffle(orders)
        Collections.shuffle(sequence)

        return ['sentences':sentences,'orders':orders,'sequence':sequence]
    }
    def writeFile(SentenceCommand sentenceCommand){
        File file = new File("participants/${sentenceCommand.userId}.txt")
        if(file.exists()){
            file << "$sentenceCommand.sentence||$sentenceCommand.solution||$sentenceCommand.time\n"
        }
        else
        {
            file.write "$sentenceCommand.sentence||$sentenceCommand.solution||$sentenceCommand.time\n"
        }
    }
}

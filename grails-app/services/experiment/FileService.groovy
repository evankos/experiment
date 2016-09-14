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
        sequence = (1 .. sents.size()).toList()
    }
    def getSentencesScrambled() {
        println "Getting Sentences"

        Collections.shuffle(orders)
        Collections.shuffle(sequence)

        return ['sentences':sentences,'orders':orders,'sequence':sequence]
    }
}

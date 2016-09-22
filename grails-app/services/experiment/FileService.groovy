package experiment

import grails.transaction.Transactional

@Transactional
class FileService {
    def sessionFactory
    def sentences
    def orders
//    def sequence
    def init(sents,ords){
        sentences = sents
        orders = ords
    }

    def getScrambledData() {


        Collections.shuffle(orders)
        Collections.shuffle(sentences)

        return ['sentences':sentences,'orders':orders]
    }
    def writeFile(String userId, SentenceCommand sentenceCommand){
        File file = new File("participants/${userId}.txt")
        if(file.exists()){
            file << "$sentenceCommand.sentence||$sentenceCommand.solution||$sentenceCommand.time||$sentenceCommand.order\n"
        }
        else
        {
            file.write "$sentenceCommand.sentence||$sentenceCommand.solution||$sentenceCommand.time||$sentenceCommand.order\n"
        }
    }
}

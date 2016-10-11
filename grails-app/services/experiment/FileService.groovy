package experiment

import grails.transaction.Transactional

@Transactional
class FileService {

    def sentences
    def orders

    def init(sents,ords){
        sentences = sents
        orders = ords
    }

    def getScrambledData() {


        def orders = new ArrayList<String>(this.orders)
        def sentences = new ArrayList<String>(this.sentences)
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

package experiment

class DataPoints {
    String solution
    String sentence
    String instruction
    Long time
    String userName
    String userID
    static constraints = {
        instruction nullable: true
        sentence nullable: true
        solution nullable: true
        time nullable: true
        userName nullable: true
        userID nullable: true
    }
}

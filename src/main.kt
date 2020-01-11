import CardDeck
import GamePlay

fun main() {
    val cd: CardDeck = CardDeck()
    val gp = GamePlay()
    gp.greetings()
    println("Hello World!")
    cd.printDeck()
}


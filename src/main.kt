import CardDeck
import GamePlay

fun main() {
    val gp = GamePlay()
    gp.greetings()
    gp.dealingCards()
    gp.printPlayerInfo()
    gp.redealingAfterFolding()
    gp.printPlayerInfo()
    for (card in CardDeck.cardDeck) println("\t${card.symbol} ${card.suit} в игре: ${card.inuse}; ")
}


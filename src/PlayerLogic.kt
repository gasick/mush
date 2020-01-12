import kotlin.random.Random
import kotlin.random.nextInt

object PlayerLogic {
    //Создаем игрока
    class player(n: String) {
        val name = n
        var points: List<Int> = listOf(startPoint)
        var dealer: Boolean = false
        var cards: MutableList<Card> = mutableListOf()
    }

    //Сбрасываем неугодные карты
    fun foldingBadCards(){
        //Разделить сброс карты на ведущего и остальных так как ведущему может не хватить карт.
        //так же логика взятия ведущего отличается от логики
        var numberOfCards = 0
        for (player in GameTable.GameTable) {
            var i = 0
            //условия скидывания карт для не ведущего игрога
            if (player.dealer != true) {
                var playerNumberOfCards =0
                for (x in player.cards.size-1 downTo 0) {
                    if (player.cards[x].suit != GameTable.trump
                        && player.cards[x].symbol != Symbols.Туз
                    ) player.cards.removeAt(x)
                    i++
                    playerNumberOfCards++
                }
                numberOfCards = playerNumberOfCards++
                // Условия скидывания карт для ведущего.
            } else {
                for (card in CardDeck.cardDeck) if (!card.inuse) remainCardsInDeck++
                for (x in player.cards.size downTo 0) {
                    fun foldCard(){
                        val n = Random.nextInt(0..player.cards.size)
                        var card = player.cards[n]
                        if (card.suit != GameTable.trump
                            || card.symbol != Symbols.Туз
                            || (card.suit != Suits.Пик && card.symbol != Symbols.Туз)
                        ) player.cards.removeAt(n)
                        else foldCard()
                    }
                    foldCard()
                }
            }
        }
    }
}
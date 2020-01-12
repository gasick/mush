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
        for (player in GameTable.GameTable) {
            //условия скидывания карт для не ведущего игрога
            if (player.dealer != true) {
                for (x in player.cards.size-1 downTo 0) {
                    if (player.cards[x].suit != GameTable.trump
                        && player.cards[x].symbol != Symbols.Туз
                    ) player.cards.removeAt(x)
                }
                // Условия скидывания карт для ведущего.
            } else {
                //Нужно запилить сброс для ведущего
                for (x in 0..CardDeck.cardDeck.size-1) {
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
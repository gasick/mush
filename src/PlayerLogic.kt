import kotlin.random.Random
import kotlin.random.nextInt

object PlayerLogic {
    //Создаем игрока
    class player(n: String) {
        val name = n
        var points: List<Int> = listOf(startPoint)
        var dealer: Boolean = false
        var cards: MutableList<Card> = mutableListOf()
        var atacker: Boolean = false

        //Атака игрока
        fun atack() {}

        //Защита игрока
        fun defence() {}
    }



    //Игрок сбрасывает неугодные карты
    fun foldingBadCards() {
        //Разделить сброс карты на ведущего и остальных так как ведущему может не хватить карт.
        //так же логика взятия ведущего отличается от логики
        for (player in GameTable.GameTable) {
            //условия скидывания карт для не ведущего игрога
            if (player.dealer != true) {
                for (x in player.cards.size - 1 downTo 0) {
                    if (player.cards[x].suit != GameTable.trump
                        && player.cards[x].symbol != Symbols.Туз
                    ) player.cards.removeAt(x)
                }
                // Условия скидывания карт для ведущего.
            } else {
                //Если в сбросе карт больше 4х тогда выбор скидывания такой же как и у обычного игрока
                if (CardDeck.cardDeck.size > 4) {
                    for (x in player.cards.size - 1 downTo 0) {
                        if (player.cards[x].suit != GameTable.trump
                            && player.cards[x].symbol != Symbols.Туз
                        ) player.cards.removeAt(x)
                    }
                } else {
                    //Если в сбросе меньше чем 4 карты тогда необоходимо выбрать карты для сброса
                    for (i in 0..CardDeck.cardDeck.size) {
                        for (x in player.cards.size - 1 downTo 0) {
                            if (player.cards[x].suit != GameTable.trump
                                && player.cards[x].symbol != Symbols.Туз
                            ) player.cards.removeAt(x)
                        }
                    }
                }
            }
        }
    }

}

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
        var AceOfSpades: Boolean = false
        var PairOfJacks: Boolean = false

        //TODO Атака игрока
        //fun atack(p: player) {
          //  for (x in player.cards.size - 1 downTo 0) {
            //    if (player.cards[x].Symbols != GameTable.trump
              //      && player.cards[x].symbol != Symbols.A
        //        ) player.cards.removeAt(x)
         //   }
         //   player.cards.sort()
            
       // }

        //TODO Защита игрока
        //fun defence(p: player): Card {

        //}

        //Проверяем ништяки
        fun checkBenefits() {
            //Количество вальтов
            var i = 0
            var red = 0
            var black = 0
            for (c in cards){
                //Если в картах на руках есть туз пик
                // помечаем это дело
                if (c.suit == Suits.Spades) AceOfSpades = true
                // Если находим вольта, прибавляем 1 к переменной
                if (c.symbol == Symbols.J) i+=1
                if (c.suit == Suits.Spades || c.suit == Suits.Clubs) black += 1
                if (c.suit == Suits.Diamonds || c.suit == Suits.Hearts) red +=1
            }
            //Проверяем, если количество вальтов больше 1
            //Тогда помечаем что у игрока есть пара вальтов
            if (i>1 && (red >1 || black > 1)) PairOfJacks = true
        }
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
                        && player.cards[x].symbol != Symbols.A
                    ) player.cards.removeAt(x)
                }
                // Условия скидывания карт для ведущего.
            } else {
                //Если в сбросе карт больше 4х тогда выбор скидывания такой же как и у обычного игрока
                if (CardDeck.cardDeck.size > 4) {
                    for (x in player.cards.size - 1 downTo 0) {
                        if (player.cards[x].suit != GameTable.trump
                            && player.cards[x].symbol != Symbols.A
                        ) player.cards.removeAt(x)
                    }
                } else {
                    //Если в сбросе меньше чем 4 карты тогда необоходимо выбрать карты для сброса
                    for (i in 0..CardDeck.cardDeck.size) {
                        for (x in player.cards.size - 1 downTo 0) {
                            if (player.cards[x].suit != GameTable.trump
                                && player.cards[x].symbol != Symbols.A
                            ) player.cards.removeAt(x)
                        }
                    }
                }
            }
        }
    }
}

import kotlin.random.Random
import kotlin.random.nextInt

class CardDeck {
    //собираем колоду карт
    var cardDeck: List<Card> = listOf(
    Card( Suits.spades, Symbols.Ace),
    Card( Suits.spades, Symbols.King) ,
    Card( Suits.spades, Symbols.Queen),
    Card( Suits.spades, Symbols.Jack) ,
    Card( Suits.spades, Symbols.Ten)  ,
    Card( Suits.spades, Symbols.Nine) ,
    Card( Suits.spades, Symbols.Eight),
    Card( Suits.spades, Symbols.Seven),
    Card( Suits.spades, Symbols.Six)  ,
    Card( Suits.hearts, Symbols.Ace)  ,
    Card( Suits.hearts, Symbols.King) ,
    Card( Suits.hearts, Symbols.Queen),
    Card( Suits.hearts, Symbols.Jack) ,
    Card( Suits.hearts, Symbols.Ten)  ,
    Card( Suits.hearts, Symbols.Nine) ,
    Card( Suits.hearts, Symbols.Eight),
    Card( Suits.hearts, Symbols.Seven),
    Card( Suits.hearts, Symbols.Six)  ,
    Card( Suits.clubs, Symbols.Ace)   ,
    Card( Suits.clubs, Symbols.King)  ,
    Card( Suits.clubs, Symbols.Queen) ,
    Card( Suits.clubs, Symbols.Jack)  ,
    Card( Suits.clubs, Symbols.Ten)   ,
    Card( Suits.clubs, Symbols.Nine)  ,
    Card( Suits.clubs, Symbols.Eight) ,
    Card( Suits.clubs, Symbols.Seven) ,
    Card( Suits.clubs, Symbols.Six)   ,
    Card( Suits.diamonds, Symbols.Ace),
    Card( Suits.diamonds, Symbols.King),
    Card( Suits.diamonds, Symbols.Queen),
    Card( Suits.diamonds, Symbols.Jack),
    Card( Suits.diamonds, Symbols.Ten),
    Card( Suits.diamonds, Symbols.Nine),
    Card( Suits.diamonds, Symbols.Eight),
    Card( Suits.diamonds, Symbols.Seven),
    Card( Suits.diamonds, Symbols.Six)
    )

    fun printDeck() {

        fun takeCard(): Card {
            //Вытаскиваем номер карты
            val n = Random.nextInt(0..35)
            //Если карта не использованна в игре то метим её как карту которая учавствовала в игре
            if (!cardDeck[n].inuse) cardDeck[n].inuse = true
            //Если карта использовалась запускаем заново функция взятия карты
            else takeCard()
            //Возвращаем карту запросившему
            return cardDeck[n]
        }

        //Вызываем все карты по порядку из колоды
        //чтобы смотрим состояние
        for (c: Card in cardDeck){
            //TODO вызвать рандомные карты из колоды.
            print("${c.symbol.toString()} of ${c.suit.toString()} is in use: ${c.inuse}; ")
        }
        println()

        //раздаем карты 4 участникам
        for (x in 1..4 ) {
           println("Player $x have:")
           for (y in 1..4){
               var card = takeCard()
               print("${card.symbol.toString()} of ${card.suit.toString()} is in use: ${card.inuse}; ")
            }
            println()
        }
        //Выводим все карты чтобы знать. что карты которые учавствовали в игре помечены к сбросу.
        for (c: Card in cardDeck){
            //TODO вызвать рандомные карты из колоды.
            print("${c.symbol.toString()} of ${c.suit.toString()} is in use: ${c.inuse}; ")
        }

    }
}


//Создаем класс карта
class Card(su: Suits,sy: Symbols) {
    //Даем карте свойство "В игре"
    var inuse: Boolean = false
    //Даем карте свойство масти
    val suit: Suits = su
    //Даем карте свойство ранга
    val symbol: Symbols = sy
}

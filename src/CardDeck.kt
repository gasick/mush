import kotlin.random.Random
import kotlin.random.nextInt

class CardDeck {
    val number = 36;
    var cardDeck: List<Card> = listOf(
    Card(0, Suits.spades, Symbols.Ace),
    Card(0, Suits.spades, Symbols.King) ,
    Card(0, Suits.spades, Symbols.Queen),
    Card(0, Suits.spades, Symbols.Jack) ,
    Card(0, Suits.spades, Symbols.Ten)  ,
    Card(0, Suits.spades, Symbols.Nine) ,
    Card(0, Suits.spades, Symbols.Eight),
    Card(0, Suits.spades, Symbols.Seven),
    Card(0, Suits.spades, Symbols.Six)  ,
    Card(0, Suits.hearts, Symbols.Ace)  ,
    Card(0, Suits.hearts, Symbols.King) ,
    Card(0, Suits.hearts, Symbols.Queen),
    Card(0, Suits.hearts, Symbols.Jack) ,
    Card(0, Suits.hearts, Symbols.Ten)  ,
    Card(0, Suits.hearts, Symbols.Nine) ,
    Card(0, Suits.hearts, Symbols.Eight),
    Card(0, Suits.hearts, Symbols.Seven),
    Card(0, Suits.hearts, Symbols.Six)  ,
    Card(0, Suits.clubs, Symbols.Ace)   ,
    Card(0, Suits.clubs, Symbols.King)  ,
    Card(0, Suits.clubs, Symbols.Queen) ,
    Card(0, Suits.clubs, Symbols.Jack)  ,
    Card(0, Suits.clubs, Symbols.Ten)   ,
    Card(0, Suits.clubs, Symbols.Nine)  ,
    Card(0, Suits.clubs, Symbols.Eight) ,
    Card(0, Suits.clubs, Symbols.Seven) ,
    Card(0, Suits.clubs, Symbols.Six)   ,
    Card(0, Suits.diamonds, Symbols.Ace),
    Card(0, Suits.diamonds, Symbols.King),
    Card(0, Suits.diamonds, Symbols.Queen),
    Card(0, Suits.diamonds, Symbols.Jack),
    Card(0, Suits.diamonds, Symbols.Ten),
    Card(0, Suits.diamonds, Symbols.Nine),
    Card(0, Suits.diamonds, Symbols.Eight),
    Card(0, Suits.diamonds, Symbols.Seven),
    Card(0, Suits.diamonds, Symbols.Six)
    )

    fun CardDeck(){
        for (c: Card in cardDeck)  {
            //TODO добавить генерацию случайного порядка карт c.numberInDeck
        }
    }
    fun printDeck() {
        fun takeCard(): Card {
            val n = Random.nextInt(1..36)
            if (!cardDeck[n].inuse) cardDeck[n].inuse = true
            else takeCard()
            return cardDeck[n]
        }
        for (c: Card in cardDeck){
            //TODO вызвать рандомные карты из колоды.
            print("${c.symbol.toString()} of ${c.suit.toString()} is in use: ${c.inuse};")
        }
        println()
        for ( x in 1..36){
            //TODO не очень выходит сделать вывод случайной карты.
            var card = takeCard()
            print("${card};")
            //println("${c.symbol.toString()} of ${c.suit.toString()}")
        }
        for (c: Card in cardDeck){
            //TODO вызвать рандомные карты из колоды.
            print("${c.symbol.toString()} of ${c.suit.toString()} is in use: ${c.inuse};")
        }

    }
}

class Card(n: Int,su: Suits,sy: Symbols) {
    var inuse: Boolean = false
    val suit: Suits = su
    val symbol: Symbols = sy
}

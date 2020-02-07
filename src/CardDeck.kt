import kotlin.random.Random 
import kotlin.random.nextInt

object CardDeck {
    //собираем колоду карт
    var cardDeck: MutableList<Card> = mutableListOf(
        Card(Suits.Hearts, Symbols.A),
        Card(Suits.Hearts, Symbols.K),
        Card(Suits.Hearts, Symbols.Q),
        Card(Suits.Hearts, Symbols.J),
        Card(Suits.Hearts, Symbols.Ten),
        Card(Suits.Hearts, Symbols.Nine),
        Card(Suits.Hearts, Symbols.Eight),
        Card(Suits.Hearts, Symbols.Seven),
        Card(Suits.Hearts, Symbols.Six),
        Card(Suits.Clubs, Symbols.A),
        Card(Suits.Clubs, Symbols.K),
        Card(Suits.Clubs, Symbols.Q),
        Card(Suits.Clubs, Symbols.J),
        Card(Suits.Clubs, Symbols.Ten),
        Card(Suits.Clubs, Symbols.Nine),
        Card(Suits.Clubs, Symbols.Eight),
        Card(Suits.Clubs, Symbols.Seven),
        Card(Suits.Clubs, Symbols.Six),
        Card(Suits.Spades, Symbols.A),
        Card(Suits.Spades, Symbols.K),
        Card(Suits.Spades, Symbols.Q),
        Card(Suits.Spades, Symbols.J),
        Card(Suits.Spades, Symbols.Ten),
        Card(Suits.Spades, Symbols.Nine),
        Card(Suits.Spades, Symbols.Eight),
        Card(Suits.Spades, Symbols.Seven),
        Card(Suits.Spades, Symbols.Six),
        Card(Suits.Diamonds, Symbols.A),
        Card(Suits.Diamonds, Symbols.K),
        Card(Suits.Diamonds, Symbols.Q),
        Card(Suits.Diamonds, Symbols.J),
        Card(Suits.Diamonds, Symbols.Ten),
        Card(Suits.Diamonds, Symbols.Nine),
        Card(Suits.Diamonds, Symbols.Eight),
        Card(Suits.Diamonds, Symbols.Seven),
        Card(Suits.Diamonds, Symbols.Six)
    )

    //Вытаскиваем из колоды карты игрокам.
    fun takeCard(): Card {
        lateinit var card: Card
        //Вытаскиваем номер карты
        val n = Random.nextInt(0..cardDeck.size-1)
        //Если карта не использованна в игре то метим её как карту которая учавствовала в игре
        if (!cardDeck[n].inuse) {
            cardDeck[n].inuse = true
            card = cardDeck[n]
            cardDeck.removeAt(n)
        }
        //Если карта использовалась запускаем заново функция взятия карты
        else takeCard()
        //Возвращаем карту запросившему
        return card
    }

    //Выводим содержание колоды.
    fun printCardDeckInfo() {
        for (card in CardDeck.cardDeck)
            when (card.inuse) {
                true -> println("\t${card.symbol} ${card.suit} в игре.")
                false -> println("\t${card.symbol} ${card.suit} не в игре.")
            }
    }
}

//Создаем класс карты
class Card(su: Suits,sy: Symbols) {
    //Даем карте свойство "В игре"
    var inuse: Boolean = false
    //Даем карте свойство масти
    val suit: Suits = su
    //Даем карте свойство ранга
    val symbol: Symbols = sy
}

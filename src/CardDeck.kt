import kotlin.random.Random
import kotlin.random.nextInt

object CardDeck {
    //собираем колоду карт
    var cardDeck: MutableList<Card> = mutableListOf(
        Card(Suits.Hearts, Symbols.Ace),
        Card(Suits.Hearts, Symbols.King),
        Card(Suits.Hearts, Symbols.Queen),
        Card(Suits.Hearts, Symbols.Jack),
        Card(Suits.Hearts, Symbols.Ten),
        Card(Suits.Hearts, Symbols.Nine),
        Card(Suits.Hearts, Symbols.Eight),
        Card(Suits.Hearts, Symbols.Seven),
        Card(Suits.Hearts, Symbols.Six),
        Card(Suits.Clubs, Symbols.Ace),
        Card(Suits.Clubs, Symbols.King),
        Card(Suits.Clubs, Symbols.Queen),
        Card(Suits.Clubs, Symbols.Jack),
        Card(Suits.Clubs, Symbols.Ten),
        Card(Suits.Clubs, Symbols.Nine),
        Card(Suits.Clubs, Symbols.Eight),
        Card(Suits.Clubs, Symbols.Seven),
        Card(Suits.Clubs, Symbols.Six),
        Card(Suits.Spades, Symbols.Ace),
        Card(Suits.Spades, Symbols.King),
        Card(Suits.Spades, Symbols.Queen),
        Card(Suits.Spades, Symbols.Jack),
        Card(Suits.Spades, Symbols.Ten),
        Card(Suits.Spades, Symbols.Nine),
        Card(Suits.Spades, Symbols.Eight),
        Card(Suits.Spades, Symbols.Seven),
        Card(Suits.Spades, Symbols.Six),
        Card(Suits.Diamonds, Symbols.Ace),
        Card(Suits.Diamonds, Symbols.King),
        Card(Suits.Diamonds, Symbols.Queen),
        Card(Suits.Diamonds, Symbols.Jack),
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
    fun printCardDeckContent() {
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

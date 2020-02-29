package CardDeck

import kotlin.random.Random
import kotlin.random.nextInt

object CardDeck {

    enum class Suits(){Hearts, Clubs, Spades, Diamonds}
    enum class Symbols() {A, K, Q, J, Ten, Nine, Eight, Seven, Six }
    class Card(use: Boolean, su: Suits, sy: Symbols) {
        var inuse = use
        var suit = su;
        var symbol = sy;
    }
    lateinit var CardDeck: MutableList<Card>
    //собираем колоду карт
    fun refreshCardDeck() {
            CardDeck = mutableListOf(
            Card(false, Suits.Hearts, Symbols.A),
            Card(false, Suits.Hearts, Symbols.K),
            Card(false, Suits.Hearts, Symbols.Q),
            Card(false, Suits.Hearts, Symbols.J),
            Card(false, Suits.Hearts, Symbols.Ten),
            Card(false, Suits.Hearts, Symbols.Nine),
            Card(false, Suits.Hearts, Symbols.Eight),
            Card(false, Suits.Hearts, Symbols.Seven),
            Card(false, Suits.Hearts, Symbols.Six),
            Card(false, Suits.Clubs, Symbols.A),
            Card(false, Suits.Clubs, Symbols.K),
            Card(false, Suits.Clubs, Symbols.Q),
            Card(false, Suits.Clubs, Symbols.J),
            Card(false, Suits.Clubs, Symbols.Ten),
            Card(false, Suits.Clubs, Symbols.Nine),
            Card(false, Suits.Clubs, Symbols.Eight),
            Card(false, Suits.Clubs, Symbols.Seven),
            Card(false, Suits.Clubs, Symbols.Six),
            Card(false, Suits.Spades, Symbols.A),
            Card(false, Suits.Spades, Symbols.K),
            Card(false, Suits.Spades, Symbols.Q),
            Card(false, Suits.Spades, Symbols.J),
            Card(false, Suits.Spades, Symbols.Ten),
            Card(false, Suits.Spades, Symbols.Nine),
            Card(false, Suits.Spades, Symbols.Eight),
            Card(false, Suits.Spades, Symbols.Seven),
            Card(false, Suits.Spades, Symbols.Six),
            Card(false, Suits.Diamonds, Symbols.A),
            Card(false, Suits.Diamonds, Symbols.K),
            Card(false, Suits.Diamonds, Symbols.Q),
            Card(false, Suits.Diamonds, Symbols.J),
            Card(false, Suits.Diamonds, Symbols.Ten),
            Card(false, Suits.Diamonds, Symbols.Nine),
            Card(false, Suits.Diamonds, Symbols.Eight),
            Card(false, Suits.Diamonds, Symbols.Seven),
            Card(false, Suits.Diamonds, Symbols.Six)
        )
    }



    //Вытаскиваем из колоды карты игрокам.
    fun takeCard(): Card {
        println(CardDeck.size)
        lateinit var card: Card
        //Вытаскиваем номер карты
        val n = Random.nextInt(0..CardDeck.size-1)
        //Если карта не использованна в игре то метим её как карту которая учавствовала в игре
        if (!CardDeck[n].inuse) {
            CardDeck[n].inuse = true
            card = CardDeck[n]
            CardDeck.removeAt(n)
        }
        //Если карта использовалась запускаем заново функция взятия карты
        else takeCard()
        //Возвращаем карту запросившему
        return card
    }

    //Выводим содержание колоды.
    fun printCardDeckInfo() {
        CardDeck.forEach { card ->
            when (card.inuse) {
                true -> println("\t${card.symbol} ${card.suit} в игре.")
                false -> println("\t${card.symbol} ${card.suit} не в игре.")
            }
        }
    }

}

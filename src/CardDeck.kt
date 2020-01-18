import kotlin.random.Random
import kotlin.random.nextInt

object CardDeck {
    //собираем колоду карт
    var cardDeck: MutableList<Card> = mutableListOf(
        Card(Suits.Червей, Symbols.Туз),
        Card(Suits.Червей, Symbols.Король),
        Card(Suits.Червей, Symbols.Дама),
        Card(Suits.Червей, Symbols.Валет),
        Card(Suits.Червей, Symbols.Десятка),
        Card(Suits.Червей, Symbols.Девятка),
        Card(Suits.Червей, Symbols.Восьмерка),
        Card(Suits.Червей, Symbols.Семерка),
        Card(Suits.Червей, Symbols.Шестерка),
        Card(Suits.Треф, Symbols.Туз),
        Card(Suits.Треф, Symbols.Король),
        Card(Suits.Треф, Symbols.Дама),
        Card(Suits.Треф, Symbols.Валет),
        Card(Suits.Треф, Symbols.Десятка),
        Card(Suits.Треф, Symbols.Девятка),
        Card(Suits.Треф, Symbols.Восьмерка),
        Card(Suits.Треф, Symbols.Семерка),
        Card(Suits.Треф, Symbols.Шестерка),
        Card(Suits.Пик, Symbols.Туз),
        Card(Suits.Пик, Symbols.Король),
        Card(Suits.Пик, Symbols.Дама),
        Card(Suits.Пик, Symbols.Валет),
        Card(Suits.Пик, Symbols.Десятка),
        Card(Suits.Пик, Symbols.Девятка),
        Card(Suits.Пик, Symbols.Восьмерка),
        Card(Suits.Пик, Symbols.Семерка),
        Card(Suits.Пик, Symbols.Шестерка),
        Card(Suits.Бубей, Symbols.Туз),
        Card(Suits.Бубей, Symbols.Король),
        Card(Suits.Бубей, Symbols.Дама),
        Card(Suits.Бубей, Symbols.Валет),
        Card(Suits.Бубей, Symbols.Десятка),
        Card(Suits.Бубей, Symbols.Девятка),
        Card(Suits.Бубей, Symbols.Восьмерка),
        Card(Suits.Бубей, Symbols.Семерка),
        Card(Suits.Бубей, Symbols.Шестерка)
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

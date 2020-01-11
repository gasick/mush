import CardDeck.takeCard

class GamePlay {
    //Создаем таблицу игры, представляем игроков
    // и подставляем всё в gametable
    fun greetings() {
        GameTable.GameTable()
    }

    //TODO раздаем карты игрокам помечаем козыря
    fun dealingCards() {
        for (player in GameTable.GameTable) {
            //Если игрок последний сдаем ему 6 карт, последняя карта задает козыря
            if (player.dealer == true) {
                for (x in 1..6) {
                    var card = takeCard()
                    player.cards.add(card)
                    //Задали козыря
                    if (x == 6) GameTable.trump = card.suit
                }
                //если игрок не последний раздаем ему 5 карт
            } else {
                for (x in 1..5) {
                    var card = takeCard()
                    player.cards.add(card)
                }
            }
        }
        for (player in GameTable.GameTable) {
            println()
            //Указываем является ли игрок последним и что у него на руках
            if (player.dealer == true) println("${player.name.toString()} - последний, имеет на руках:")
            else println("${player.name.toString()} имеет на руках:")
            for (card in player.cards) {
                println("\t${card.symbol.toString()} ${card.suit.toString()} в игре: ${card.inuse}; ")
            }
        }
        //Тут печатаем основную информацию о том, какие карты у игроков и какой козырь.
        println()
        println("Козырь: ${GameTable.trump.toString()}")
        println("\t Имя \t Количество очков")
        for (player in GameTable.GameTable) {
            println("\t ${player.name}: \t ${player.points.toString()} ")
        }
    }
    //TODO каждый из игроков проверяет полученные карты и в случае если не удовлетворен раздачей просит пересдать
    fun redealingAfterFolding() {
        PlayerLogic.foldingBadCards()

    }
    //TODO Кон игры(повторяем 4 раза, по количеству наличествующих карт)
    //TODO Подсчитываем очки у игроков
    //TODO подсчитываем общее число очков подводим итоги игры
    //TODO
    //TODO
    //TODO
    //TODO
    //TODO
    //TODO

}
import CardDeck

class GamePlay {


    //Создаем таблицу игры, представляем игроков
    // и подставляем всё в gametable
    fun greetings() {
        GameTable.GameTable()
    }

    //раздаем карты игрокам помечаем козыря
    fun dealingCards() {
        for (player in GameTable.GameTable) {
            //Если игрок последний сдаем ему 6 карт, последняя карта задает козыря
            if (player.dealer == true) {
                for (x in 1..6) {
                    var card = CardDeck.takeCard()
                    player.cards.add(card)
                    //Задали козыря
                    if (x == 6) GameTable.trump = card.suit
                }
                //если игрок не последний раздаем ему 5 карт
            } else {
                for (x in 1..5) {
                    var card = CardDeck.takeCard()
                    player.cards.add(card)
                }
            }
        }
    }
    //каждый из игроков проверяет полученные карты и в случае если не удовлетворен раздачей просит пересдать
    fun redealingAfterFolding() {
        //Игроки скидывают плохие карты
        PlayerLogic.foldingBadCards()
        //Игрокам раздаются недостающие карты.
        for (player in GameTable.GameTable){
            for (x in 1..5-player.cards.size) {
                var card = CardDeck.takeCard()
                player.cards.add(card)
            }
        }
    }

    //TODO Кон игры(повторяем 5 раза, по количеству наличествующих карт)
    // Нужно сделать чтобы игроки ходили по кругу

    fun round() {
        //Проходимся по всем игрокам
        for (i in 0..GameTable.GameTable.size)
            //если игрок первый, то он начинает атаковать.
            when (GameTable.GameTable[i].atacker) {
                true -> GameTable.GameTable[i].atack()
                false -> GameTable.GameTable[i].defence()
            }

        fun runcircle(n: Int) {
            when(n){
                0 -> {
                    for (i in 0..GameTable.GameTable.size)
                    //если игрок первый, то он начинает атаковать.
                        when (GameTable.GameTable[i].atacker) {
                            true -> GameTable.GameTable[i].atack()
                            false -> GameTable.GameTable[i].defence()
                        }
                        //TODO тут где-то игроки должны выкладывать карты по очереди. и кто бьет всю кучу должен стать
                        // новым атакующим.
                }
                else -> {
                    for (i in n-1 .. GameTable.GameTable.size-1) {
                        // TODO тут мы будем выкладывать по очереди карты
                        when (GameTable.GameTable[i].atacker) {
                            true -> GameTable.GameTable[i].atack()
                            false -> GameTable.GameTable[i].defence()
                        }
                    }
                    for (i in 0 .. n-2) {
                        // Продолжаем выклыадывать остатки карт
                        // TODO тут мы  обозначаем победителя хода
                        // сбрасываем карты и начинаем новый ход
                        when (GameTable.GameTable[i].atacker) {
                            true -> GameTable.GameTable[i].atack()
                            false -> GameTable.GameTable[i].defence()
                        }
                    }
                }
            }
        }








        //TODO Меняем игроков местами так чтобы каждый следующий кон
        // начинал игрок который побил карты противников карты

        //В конце раунда меняем ведущего на следующего игрока.
        GameTable.changeDealer()

    }
    //TODO Подсчитываем очки у игроков
    // подсчитываем общее число очков подводим итоги игры
    //TODO
    //TODO
    //TODO
    //TODO
    //TODO
    //TODO
    //Печатаем информацию о том какие карты у кого.
    fun printPlayerInfo() {
        // печетаем информацию о игроках
        for (player in GameTable.GameTable) {
            println()
            //Указываем что игрок является атакующим
            if (player.atacker) println("${player.name} - Первый в кону")
            //Указываем является ли игрок последним и что у него на руках
            when (player.dealer) {
                true -> println("${player.name} - последний, имеет на руках:")
                false -> println("${player.name} имеет на руках:")
            }


            for (card in player.cards)
                println("\t${card.symbol} ${card.suit} в игре.")
        }
        //Тут печатаем основную информацию о том, какие карты у игроков и какой козырь.
        println()
        println("Козырь: ${GameTable.trump}")
        println("\t Имя \t Количество очков")
        for (player in GameTable.GameTable)
            println("\t ${player.name}: \t ${player.points.toString()} ")
    }

}
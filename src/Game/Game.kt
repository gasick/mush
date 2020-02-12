package Game

import Players.Players.player
import Players.Players
import CardDeck.CardDeck.Suits
import CardDeck.CardDeck


object Game {
    //Создаем таблицу в виде списка
    var GameTable: MutableList<player> = mutableListOf()
    //тестово указываем козырь для игры
    var trump: Suits = Suits.Clubs

    fun greetings() {
      GameTable()
    }


    //Заполняем таблицу данными
    fun GameTable() {
        for (i in 0..3) {
            println("Введите Имя игрока: Player$i")
//        var playerName: String = readLine()!!.toString()
            var playerName: String = "Player$i"
            if (i == 3) {
                GameTable.add(player(playerName))
                GameTable[i].dealer = true
            } else {
                GameTable.add(player(playerName))
            }
            //Присвоили первому игроку статус атакующего.
            if (i == 0) GameTable[i].atack = true
        }
    }

    fun refreshPlayerCards(){
        for (p in GameTable){ p.cards.clear()}
    }


    //Меняем ведущего игрока на следующего в очереди по кругу
    fun changeDealer() {
        for (i in 0..GameTable.size-1)
        //Меняем ведущего.
            if (GameTable[i].dealer)
                when (i) {
                    //Если он последний тогда указываем что теперь
                    //ведущий первый игрок
                    GameTable.size-1 -> GameTable[0].dealer = true
                    //Если он не последний, то следующий за ним игрок ведущий
                    else -> GameTable[i+1].dealer = true

                }
    }


    //раздаем карты игрокам помечаем козыря
    fun dealingCards() {
        for (player in GameTable) {
            //Если игрок последний сдаем ему 6 карт, последняя карта задает козырь
            if (player.dealer == true) {
                for (x in 1..6) {
                    var card = CardDeck.takeCard()
                    player.cards.add(card)
                    //Задали козыря
                    if (x == 6) trump = card.suit
                }
                //если игрок не последний раздаем ему 5 карт
            } else {
                for (x in 1..5) {
                    player.cards.add(CardDeck.takeCard())
                }
            }
        }
    }

    //каждый из игроков проверяет полученные карты и в случае если не удовлетворен раздачей просит пересдать
    fun redealingAfterFolding() {

        //Игрокам раздаются недостающие карты.
        for (player in GameTable){
            for (x in 1..5-player.cards.size) {
                player.cards.add(CardDeck.takeCard())
            }
        }
    }
    //Игрок сбрасывает неугодные карты
    fun foldingBadCards() {
        //Разделить сброс карты на ведущего и остальных так как ведущему может не хватить карт.
        //так же логика взятия ведущего отличается от логики
        for (player in GameTable) {
            //условия скидывания карт для не ведущего игрога
            if (player.dealer != true) {
                for (x in player.cards.size - 1 downTo 0) {
                    if (player.cards[x].suit != trump
                        && player.cards[x].symbol != CardDeck.Symbols.A
                    ) player.cards.removeAt(x)
                }
                // Условия скидывания карт для ведущего.
            } else {
                //Если в сбросе карт больше 4х тогда выбор скидывания такой же как и у обычного игрока
                if (CardDeck.CardDeck.size > 4) {
                    for (x in player.cards.size - 1 downTo 0) {
                        if (player.cards[x].suit != trump
                            && player.cards[x].symbol != CardDeck.Symbols.A
                        ) player.cards.removeAt(x)
                    }
                } else {
                    //Если в сбросе меньше чем 4 карты тогда необоходимо выбрать карты для сброса
                    for (i in 0..CardDeck.CardDeck.size) {
                        for (x in player.cards.size - 1 downTo 0) {
                            if (player.cards[x].suit != trump
                                && player.cards[x].symbol != CardDeck.Symbols.A
                            ) player.cards.removeAt(x)
                        }
                    }
                }
            }
        }


    }





    fun printPlayerInfo() {
        // печетаем информацию о игроках
        for (player in GameTable) {
            println()
            //Указываем что игрок является атакующим
            if (player.atack) println("${player.name} - Первый в кону")
            //Указываем является ли игрок последним и что у него на руках
            when (player.dealer) {
                true -> println("${player.name} - последний, имеет на руках:")
                false -> println("${player.name} имеет на руках:")
            }

            print("\t")
            for (card in player.cards) print("${card.symbol} - ${card.suit}, ")
            println()

            // TODO запилить сортировку карт у игроков
            //  player.cards.sort()
            print("\t")
            for (card in player.cards) print("${card.symbol} - ${card.suit}, ")
            println()
        }
        //Тут печатаем основную информацию о том, какие карты у игроков и какой козырь.
        println()
        println("Козырь: ${trump}")
        println("\t Имя \t Количество очков")
        for (player in GameTable)
            println("\t ${player.name}: \t ${player.points.toString()} ")
    }

    fun round() {
        //Находим атакующего игрока и вызывваем метод по кругу
        for (i: Int in 0..GameTable.size-1)
            if (GameTable[i].atack)
                getCircle(i)

    }
    //Нужно придумать как будет обходиться круг когда атакующий первый или последний
    fun getCircle(i: Int){
        for (j in i..GameTable.size-1){GameTable[i].defence()}
        for (j in 0..i){GameTable[i].defence()}
    }

    //Проверяем сколько очков у нас получается
    //Проверяем ништяки
//    fun checkBenefits() {
//        //Количество вальтов
//        var i = 0
//        var red = 0
//        var black = 0
//        for (c in cards) {
//            //Если в картах на руках есть туз пик
//            // помечаем это дело
//            if (c.suit == Suits.Spades) AceOfSpades = true
//            // Если находим вольта, прибавляем 1 к переменной
//            if (c.symbol == CardDeck.Symbols.J) i += 1
//            if (c.suit == Suits.Spades || c.suit == Suits.Clubs) black += 1
//            if (c.suit == Suits.Diamonds || c.suit == Suits.Hearts) red += 1
//        }
//        //Проверяем, если количество вальтов больше 1
//        //Тогда помечаем что у игрока есть пара вальтов
//        if (i > 1 && (red > 1 || black > 1)) PairOfJacks = true
//    }

    //Делаем подготовительные шаги для нового раунда
    fun endOfRound() {
        CardDeck.refreshCardDeck()
    }


}



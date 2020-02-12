import CardDeck.CardDeck
import Game.Game
import Players.Players

fun main() {
    //Создаем таблицу игроков узнаем имена и задаем количество очков
    Game.GameTable()
    while(true) {
        println("Начался кон")
        //тасуем карты
        CardDeck.refreshCardDeck()
        //Раздаем карты
        Game.dealingCards()
        //Печатаем инфу о картах
        Game.printPlayerInfo()
        //Печатаем инфу о картах в колоде
        CardDeck.printCardDeckInfo()
        //Скидывваем плохие карты
        Game.foldingBadCards()
        //Перераздаем остатки карт
        Game.redealingAfterFolding()
        //Печатаем инфу о игроках
        Game.printPlayerInfo()
        //Печатаем инфу о том какие карты лежат в колоде
        CardDeck.printCardDeckInfo()
        //Играем кон 5 раз, по количеству карт у каждого игрока.
        for (i in 0..4) {
            println("Ход начался")
            Game.round()
            Game.endOfRound()
            println("Ход закончился")
        }
        //Game.checkBenefits()
        println("Закончился кон")
    }


}
import CardDeck.CardDeck
import Game.Game

fun main() {
    //Создаем таблицу игроков узнаем имена и задаем количество очков
    //Вместо GameTable() должен быть greetings()
    Game.GameTable()
   for (i in 1..5){
        println("Начался кон")
        //тасуем карты
        CardDeck.refreshCardDeck()
        Game.cleanPlayerCards()
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
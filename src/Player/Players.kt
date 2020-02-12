package Players

import CardDeck.CardDeck.Card
import CardDeck.CardDeck
import Game.Game
import CardDeck.CardDeck.Symbols
import CardDeck.CardDeck.Suits

object Players {
    var startPoints = 25

    var Players: MutableList<player> = mutableListOf()

    class player(n: String) {
        val name = n;
        var points: Int = startPoints
        var cards: MutableList<Card> = mutableListOf()
        var dealer = false
        var atack = false
        var AceOfSpades = false
        var PairOfJacks = false
        var FourJacks = false


        //TODO atack
        fun atack() {}

        //TODO defence
        fun defence() {}




    }
}

package Players

import CardDeck.CardDeck.Card
import CardDeck.CardDeck
import Game.Game
import CardDeck.CardDeck.Symbols
import CardDeck.CardDeck.Suits
import Game.Game.table

object Player {
    var startPoints = 25
    var startTakes = 0

    class Player(n: String) {
        val name = n;
        var points: Int = startPoints
        var takes: Int= startTakes
        var cards: MutableList<Card> = mutableListOf()
        var dealer = false
        var atack = false
        var AceOfSpades = false
        var PairOfJacks = false
        var FourJacks = false


        //TODO atack
        fun turn(): Card {
            //Проверяем если человек первый кто выкладывает карты то карта выбирается по принципу
            //максимально полезная
            if (this.atack){
                lateinit var card: Card
                for (c in this.cards){
                    if (c.suit == Suits.Spades && c.symbol == Symbols.A) table = Pair<player, c>
                }
                return card
            }
            //Если игрок защищается то карта выбирается либо бьющая либо минимально полезная.
            else {
                return
            }
        }

        //TODO check Cards
        //Проверяеям ништяки которые может быть получили игроки.
        fun checkCards() {
            var JackPairB = 0
            var JackPairR = 0
            for (c in cards){
                //Если есть пары вальтов или туз пик то отмечаем это
                if (c.symbol == Symbols.A && c.suit == Suits.Spades) AceOfSpades = true
                if (c.symbol == Symbols.J && (c.suit == Suits.Hearts || c.suit == Suits.Diamonds)) JackPairR++
                if (c.symbol == Symbols.J && (c.suit == Suits.Spades|| c.suit == Suits.Clubs)) JackPairB++
            }
            if (JackPairB == 2 || JackPairR == 2) this.PairOfJacks=true
            if (JackPairB+JackPairR == 4) this.FourJacks = true
        }


    }
}

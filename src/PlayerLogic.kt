object PlayerLogic {
    //Создаем игрока
    class player(n: String) {
        val name = n
        var points: List<Int> = listOf(startPoint)
        var dealer: Boolean = false
        var cards: MutableList<Card> = mutableListOf()
    }

    //Сбрасываем неугодные карты
    fun foldingBadCards(): Int {
        //Разделить сброс карты на ведущего и остальных так как ведущему может не хватить карт.
        //так же логика взятия ведущего отличается от логики
        var numberOfCards = 0
        for (player in GameTable.GameTable) {
            var i = 0
            //условия скидывания карт для не ведущего игрога
            if (player.dealer != true) {
                for (card in player.cards) {
                    if (card.suit != GameTable.trump
                        && card.symbol != Symbols.Туз
                        && (card.suit != Suits.Пик && card.symbol != Symbols.Туз)
                    ) player.cards.removeAt(i)

                    i++
                }
            // Условия скидывания карт для ведущего.
            } else {

            }
        }
        return numberOfCards
    }
}
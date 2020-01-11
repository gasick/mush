object GameTable {
    var GameTable: MutableList<player> = mutableListOf()
    var trump: Suits = Suits.Бубей
    fun GameTable(): MutableList<player> {
        for (i in 0..3) {
            println("Введите Имя игрока:")
            var playerName: String = readLine()!!.toString()
            if (i == 3){
                GameTable.add(player(playerName))
                GameTable[i].lastPlayer = true
            } else {
                GameTable.add(player(playerName))
            }
        }

        return GameTable
    }
}

class player(n: String) {
    val name = n
    var points: List<Int> = listOf(startPoint)
    var lastPlayer: Boolean = false
}
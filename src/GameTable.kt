class GameTable {
    //TODO добавить игроков с полями для имени и очков
    fun GameTable() {
        for (i in 1..4) {
            println("Введите Имя игрока:")
            var playerName: String = readLine()!!.toString()
            GameTable.add(player(playerName))
        }
    }

    lateinit var GameTable: MutableList<player>
}

class player(n: String) {
    val name = n
    var Points: List<Int> = listOf(startPoint)
}
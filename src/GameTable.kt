object GameTable {
    //Создаем таблицу в виде списка
    //Таблица у нас синглетон(если я не ошибаюсь)
    var GameTable: MutableList<player> = mutableListOf()
    //тестово указываем козырь для игры
    var trump: Suits = Suits.Бубей

    //Заполняем таблицу данными
    fun GameTable(): MutableList<player> {
        for (i in 0..3) {
            println("Введите Имя игрока:")
            var playerName: String = readLine()!!.toString()
            if (i == 3) {
                GameTable.add(player(playerName))
                GameTable[i].lastPlayer = true
            } else {
                GameTable.add(player(playerName))
            }
        }

        //Возвращаем таблицу
            return GameTable
    }
}

//Создаем игрока
class player(n: String) {
    val name = n
    var points: List<Int> = listOf(startPoint)
    var lastPlayer: Boolean = false
}
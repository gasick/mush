import PlayerLogic.player

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
                GameTable[i].dealer = true
            } else {
                GameTable.add(player(playerName))
            }
        }

        //Возвращаем таблицу
            return GameTable
    }
}



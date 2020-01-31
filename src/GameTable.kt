import PlayerLogic.player

object GameTable {
    //Создаем таблицу в виде списка
    //Таблица у нас синглетон(если я не ошибаюсь)
    var GameTable: MutableList<player> = mutableListOf()
    //тестово указываем козырь для игры
    var trump: Suits = Suits.Clubs

    //Заполняем таблицу данными
    fun GameTable() {
        for (i in 0..3) {
            println("Введите Имя игрока: Player$i")
//            var playerName: String = readLine()!!.toString()
            var playerName: String = "Player$i"
            if (i == 3) {
                GameTable.add(player(playerName))
                GameTable[i].dealer = true
            } else {
                GameTable.add(player(playerName))
            }
            //Присвоили первому игроку статус атакующего.
            if (i == 0) GameTable[i].atacker = true
        }
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
}



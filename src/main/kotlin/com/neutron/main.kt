package com.neutron

fun main() {
    val game = Game()
    var inp: Int
    while (true) {
        try {
            game.printBoard()
            try {
                inp = readLine()!!.toInt()
            } catch (_: NumberFormatException) {
                System.err.println("Invalid input")
                continue
            } catch (_: NullPointerException) {
                System.err.println("Invalid input")
                continue
            }
            try {
                game.handleInput(inp)
            } catch (e: IndexOutOfBoundsException) {
                System.err.println("Too large/small number, try between 1-9")
                //e.printStackTrace()
                continue
            } catch (e: AlreadyUsedException) {
                System.err.println("Place already used")
                //e.printStackTrace()
                continue
            }
            game.computerTurn()
            if (game.hasWon()) {
                println("${game.winner.toStr()} has won")
                println("Game Over")
                return
            }
        } catch (e: NoSuchElementException) {
            return
        }
    }
}

private fun Game.Winner.toStr() = when(this) {
    Game.Winner.None -> "No one"
    Game.Winner.Computer -> "Computer"
    Game.Winner.User -> "User"
}
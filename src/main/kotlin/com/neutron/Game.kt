package com.neutron

import kotlin.system.exitProcess

class Game {
    private var board: Array<CharArray> = Array(3) { CharArray(3) { ' ' } }
    private var possibleOpts = mutableSetOf(0,1,2,3,4,5,6,7,8)
    enum class Winner {
        User,
        Computer,
        None
    }
    var winner = Winner.None
    /** Handle user input */
    @Throws(IndexOutOfBoundsException::class, AlreadyUsedException::class)
    fun handleInput(inp: Int) {
        move(inp, userIcon)
        possibleOpts.remove(inp-1)
    }
    fun computerTurn() {
        val x = possibleOpts.random()
        try {
            move(x, compIcon)
        }catch(e: Exception) {
            computerTurn()
            return
        }
        possibleOpts.remove(x)
    }
    private fun move(_inp: Int, icon: Char) {
        var inp = _inp
        if(icon == compIcon) inp++
        if(inp == -1)
            exitProcess(0)
        if(inp < 1)
            throw IndexOutOfBoundsException("1")
        if(inp < 4) {
            if(isPlaceUsed(inp))
                throw AlreadyUsedException("2")
            board[0][inp-1] = icon
        }else if(inp < 7) {
            if(isPlaceUsed(inp))
                throw AlreadyUsedException("3")
            board[1][inp-4] = icon
        }else if(inp < 10) {
            if(isPlaceUsed(inp))
                throw AlreadyUsedException("4")
            board[2][inp-7] = icon
        }else{
            throw IndexOutOfBoundsException("5")
        }
    }
    private fun isPlaceUsed(x: Int): Boolean {
        if(x-1 !in possibleOpts) return true
        return false
    }
    fun hasWon(): Boolean {
        if( ((board[0][0] == userIcon && board[0][1] == userIcon && board[0][2] == userIcon) ||
            (board[1][0] == userIcon && board[1][1] == userIcon && board[1][2] == userIcon)  ||
            (board[2][0] == userIcon && board[2][1] == userIcon && board[2][2] == userIcon)) ||
            (board[0][0] == userIcon && board[1][1] == userIcon && board[2][2] == userIcon)) {
            winner = Winner.User
            return true
        }else if(   ((board[0][0] == compIcon && board[0][1] == compIcon && board[0][2] == compIcon) ||
                    (board[1][0] == compIcon && board[1][1] == compIcon && board[1][2] == compIcon)  ||
                    (board[2][0] == compIcon && board[2][1] == compIcon && board[3][2] == compIcon)) ||
                    (board[0][0] == compIcon && board[1][1] == compIcon && board[2][2] == compIcon)) {
            winner = Winner.Computer
            return true
        }
        winner = Winner.None
        return false
    }
    fun printBoard() {
        for(y in 0..2) {
            for(x in 0..2) {
                if(x != 2)
                    print("${board[y][x]} | ")
                else
                    print(board[y][x])
            }
            if(y != 2)
                println("\n---------")
        }
        println()
    }
    companion object {
        const val userIcon = 'O'
        const val compIcon = 'X'
    }
}
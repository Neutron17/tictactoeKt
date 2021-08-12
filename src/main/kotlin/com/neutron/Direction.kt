package com.neutron

enum class Direction {
    Up,
    Down,
    Left,
    Right,
    None
}
fun Char.toDirection(): Direction {
    return when(this.lowercaseChar()) {
        'w', 'u' -> Direction.Up
        'a', 'l' -> Direction.Left
        's' -> Direction.Down
        'd', 'r' -> Direction.Right
        else -> Direction.None
    }
}
fun Direction.toChar(): Char {
    return when(this) {
        Direction.Up -> 'w'
        Direction.Left -> 'a'
        Direction.Down -> 's'
        Direction.Right -> 'd'
        else -> ' '
    }
}
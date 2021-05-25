package study.example.selection

import study.example.selection.Color.*

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color") // 분기 조건에 맞는 값이 없을 경우
    }

fun mixOptimized ( c1: Color, c2: Color ) =
    when { // when 에 아무 인자도 없다.
        (c1 == RED && c2 == YELLOW) ||
        (c1 == YELLOW && c2 == RED) ->
            ORANGE
        (c1 == YELLOW && c2 == BLUE) ||
        (c1 == BLUE && c2 == YELLOW) ->
            GREEN
        (c1 == BLUE && c2 == VIOLET) ||
        (c1 == VIOLET && c2 == BLUE) ->
            INDIGO
        else -> throw Exception("Dirty color ")
    }

fun main(){
    println("RED, YELLOW MIX RESULT -> ${mix(RED, YELLOW)}")
    println("RED, YELLOW MIX OPTIMIZE RESULT -> ${mix(RED, YELLOW)}")
}
package study.example.selection

fun getMnemonic(color :Color)
    = when(color) {
    Color.RED -> "홍길동"
    Color.ORANGE -> "김서방"
    Color.YELLOW -> "아무개"
    Color.GREEN -> "갑을병"
    Color.BLUE -> "코틀린"
    Color.INDIGO -> "재밌다"
    Color.VIOLET -> "정말로"
}

fun getWarmth (color : Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

fun main() {
    println(getMnemonic(Color.RED))
    println(getWarmth(Color.GREEN))
}
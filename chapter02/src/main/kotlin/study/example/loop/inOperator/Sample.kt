package study.example.loop.inOperator

fun recognize(c: Char) = when(c) {
    in '0'..'9' -> "$c 는 숫자!"
    in 'a'..'z', in 'A'..'Z' -> "$c 는 알파벳!"
    else -> "$c 는 모르겠어..."
}

fun main(){
    println(recognize('8'))
    println(recognize('A'))
    println(recognize('가'))

    // 문자열을 통한 Comparable 이터레이션 확인
    println("Kotlin" in "Java".."Scala")
    println("Kotlin" in "J".."S")

    println("Kotlin" in setOf("Java", "Scala"))
}
package study.example.collection

fun main() {
    val strings = listOf("첫번째", "두번째", "세번째")
    println("마지막 원소 추출 ${strings.last()}")

    val numbers = setOf(1,14,2)
    println("최대값 추출 ${numbers.maxOrNull()?:"null"}")
}
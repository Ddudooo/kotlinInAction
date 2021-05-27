package study.example.strings

fun main() {
    val sampleString = "12.345-6.A"
    println(sampleString.split("\\.|-".toRegex()))

    println(sampleString.split(".", "-"))
}
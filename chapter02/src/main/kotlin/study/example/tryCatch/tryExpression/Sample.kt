package study.example.tryCatch.tryExpression

import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader: BufferedReader) {
    val number = try {
        // 아래 식이 try 식의 값
        Integer.parseInt(reader.readLine())
    } catch (e : NumberFormatException) {
        return
    }
    println(number)
}

fun main() {
    val reader = BufferedReader(StringReader("239"))
    readNumber(reader)
}
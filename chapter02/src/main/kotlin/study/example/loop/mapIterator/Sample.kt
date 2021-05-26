package study.example.loop.mapIterator

import java.util.*

// 키에 대해 정렬을 위해 TreeMap 사용
val binaryReps = TreeMap<Char, String>()


fun main() {
    for (c in 'A'..'F') { // A부터 F까지 문자의 범위 지정
        // 아스키 코드를 2진 표현으로 변경
        val binary = Integer.toBinaryString(c.toInt())
        // 문자를 키값으로 2진표현식을 맵에 넣음
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) { // 맵에 대해 이터레이션
        println("$letter = $binary")
    }
}
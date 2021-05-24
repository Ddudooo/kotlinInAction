package study.example.variable

fun main() {
    val sample = "변수 예제."

    val temp = 90           // 타입 선언 생략
    val temp2 : Int = 10    // 타입 선언

    val double_value = 7.5e6 // Double 타입 변수

    println("double_value - java ${double_value.javaClass.name}")// double
    println("double_value - kotlin ${double_value.javaClass.kotlin}")// double
    println("double_value - kotlin ${double_value.javaClass.kotlin.qualifiedName}")// kotlin.Double

    //초기화식 사용 안할시 타입 명시 필수
    val temp3 : Int
    temp3 = 99
}
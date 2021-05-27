package study.example.collection

fun main(){
    // to 중위 함수 호출
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    // 맵 요소에 대한 구조 분해
    for((key, value) in map){
        println("$key = $value")
    }
}
package study.example.loop.mapIterator

fun main(){
    val list = arrayListOf("10", "11","1001")

    for((index, element) in list.withIndex()) { //인덱스와 함께 이터레이션
        println("$index: $element")
    }
}
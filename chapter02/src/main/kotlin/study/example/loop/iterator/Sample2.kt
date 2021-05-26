package study.example.loop.iterator

fun main(){
    val size = 100

    println("until 사용하는 for 문")
    for(x in 0 until size){
        println("x = $x")
    }

    println("사용하지 않을시 범위 표현식은 다음과 같음")
    for(x in 0..size-1){
        println("x = $x")
    }
}
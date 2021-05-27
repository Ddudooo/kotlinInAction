package study.example.collection

fun main(args: Array<String>){
    val list = listOf("args: ", *args) // 스프레드 연산자 사용 컬렉션을 요소 단위로 분리
    println(list)
}
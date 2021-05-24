package study.example.variable

fun main(args: Array<String>) {
    val name = "코틀린 인 액션!"
    println("공부하자! $name")

    if(args.isNotEmpty()){
        println("메인 함수 매개변수 첫번째 - ${args[0]}")
    }

    println("메인 함수 매개변수, ${if (args.isNotEmpty()) "첫번째${args[0]}" else "없음"}!")
}
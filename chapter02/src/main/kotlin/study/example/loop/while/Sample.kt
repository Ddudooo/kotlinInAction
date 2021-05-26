package study.example.loop.`while`

fun main() {
    var condition: Int = 0;

    println("while 문")
    while(condition<10){
        println("condition = ${condition++}")
    }

    condition = 0;
    
    println("do-while 문")
    do {
        println("condition = ${condition++}")
    } while(condition<10)
}
package study.example.extension

//fun String.lastChar(): Char = this.get(this.length-1)
// 수신 객체 멤버에 this 없이 접근 가능
fun String.lastChar(): Char = get(length-1)

fun main(){
    val example = "안녕하세요!"
    println("$example is last char = ${example.lastChar()}")
}
package study.example.extension

//fun String.lastChar(): Char = this.get(this.length-1)
// 수신 객체 멤버에 this 없이 접근 가능
//fun String.lastChar(): Char = get(length-1)

//확장 프로퍼티로 선언
val String.lastChar: Char
    get() = get(length-1)

var StringBuilder.lastChar: Char
    get() = get(length-1)
    set(value: Char) {
        this.setCharAt(length-1,value)
    }

fun main(){
    val example = "안녕하세요!"
    println("$example is last char = ${example.lastChar}")

    val sb = StringBuilder("Kotlin?")
    println("StringBuilder = $sb , last char = ${sb.lastChar}")
    sb.lastChar = '!'
    println("StringBuilder = $sb , last char = ${sb.lastChar}")
}
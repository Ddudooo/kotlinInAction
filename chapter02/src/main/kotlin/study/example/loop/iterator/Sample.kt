package study.example.loop.iterator

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 ==0 -> "Buzz "
    else -> "$1"
}

fun main() {
    println("for 문으로 피즈버즈 호출")
    for(i in 1..100) {
        println(fizzBuzz(i))
    }

    println("100 부터 거꾸로 짝수만.")
    for(i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }
}
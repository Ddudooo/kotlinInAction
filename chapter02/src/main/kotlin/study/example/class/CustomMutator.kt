package study.example.`class`

class Rectangle(val height: Int, val width: Int){
    val isSquare: Boolean
        get() = height == width
}

fun main() {
    val rect1 = Rectangle(1,2)
    println("rect1 is Square? ${rect1.isSquare}")

    val rect2 = Rectangle(2,2)
    println("rect2 is Square? ${rect2.isSquare}")
}
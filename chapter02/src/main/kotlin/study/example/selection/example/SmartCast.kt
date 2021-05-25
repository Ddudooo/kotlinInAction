package study.example.selection.example

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

/*
fun eval(e: Expr) :Int {
    if( e is Num){
        val n = e as Num //강제 형변환
        return n.value
    }
    
    if( e is Sum) {
        return eval(e.left) + eval(e.right) // 스마트 캐스트
    }

    throw IllegalArgumentException("Unknown expression")
}
*/
/*
fun eval(e: Expr) :Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        eval(e.left) + eval(e.right)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }
*/
fun eval(e: Expr) :Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }


fun main() {
    //(1+2)+4
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}
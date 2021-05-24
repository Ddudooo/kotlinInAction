package study.example.`class`

class Person(
    val name: String, // 읽기 전용 프로퍼티 | private 필드, public 게터 생성
    var isMarried: Boolean // 변경 가능 프로퍼티 | private 필드, public 게터, 세터 생성
)

fun main(){
    val temp = Person("이름", false);

    // temp.name = "변경 불가!"
    temp.isMarried = true

}
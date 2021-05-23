package study.example

// 데이터 클래스 -> 롬복 @Data 어노테이션과 유사한 기능
data class Person(
    // 기본 생성자 선언과 클래스의 프로퍼티 정의
    val name: String,
    val age: Int? = null // 널이 가능한 타입의 경우 표기
)
// 최상위 함수
fun main(/*args: Array<String> // 버전이 올라감에 따라 필수값이 아님*/) {
    /*: List<Person> 타입 추론으로 타입 선언 생략*/
    val persons = listOf(Person("영희"),
        Person("철수", age = 29)) // <- 프로퍼티 지정 파라미터

    val oldest = persons.maxByOrNull { it.age ?:0 } //람다식과 엘비스 연산자
    // 위의 람다 식의 경우 아래와 같은 람다식을 축약형으로 표현한것.
    // persons.maxByOrNull({ person -> person.age ?:0 })
    println("나이가 가장 많은 사람: $oldest") // 문자열 템플릿
}


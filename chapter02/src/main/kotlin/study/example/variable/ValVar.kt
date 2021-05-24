package study.example.variable

fun main(args: Array<String>) {
    val temp = "불변 타입 변수 선언"

    //temp = "다시 초기화시 컴파일 에러 발생!"

    val temp2: String

    if(args.isNotEmpty()){
        temp2 ="불변 변수의 지연 초기화"
    }else{
        temp2 = "컴파일상 초기화 문장이 한번만 실행시 여러값으로 초기화 가능."
    }

    val temp3 = arrayListOf("예제")
    temp3.add("불변 참조 선언이 되었어도 참조이기에 해당 참조 내부 객체 변경 가능")
}
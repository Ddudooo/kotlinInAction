package study.classSample

// abstract 로 추상 클래스로 선언
abstract class Animated {
    abstract fun animate() // 추상 함수로 구현체에서 반드시 오버라이드 해야함
    
    // 추상 클래스에 속하더라도 비추상 함수는 기본적으로 final 상태로, 필요시 open을 명시적으로 설정
    open fun stopAnimating() {} 
    fun animateTwice() {}
}
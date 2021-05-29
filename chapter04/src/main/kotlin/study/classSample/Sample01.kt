package study.classSample

/*class Button: Clickable {
    override fun click() = println("버튼 클릭!")
}*/

class Button: Clickable, Focusable {
    override fun click() = println("버튼 클릭!")
    override fun showOff() {
        // 이름과 시그니처가 같은 디폴트 메소드가 둘 이상 있는 경우
        // 구현 객체에서 명시적으로 오버라이드 해야함
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main(){
    Button().click()
}
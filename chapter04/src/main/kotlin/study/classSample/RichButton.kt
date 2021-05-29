package study.classSample

//open 키워드로 상속 가능한 클래스로 선언
open class RichButton: Clickable {
    fun disable() {} // 해당 메소드의 경우 상속 불가능

    open fun animate() {} // open 키워드로 상속 가능 알림 

    override fun click() { // 상위 클래스에서 선언된 메소드의 경우, 기본적으로 open 상태와 동일

    }

}
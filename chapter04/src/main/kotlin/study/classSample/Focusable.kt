package study.classSample

interface Focusable {
    fun setFocus(b: Boolean) = println("포커스 ${if(b) "됨" else "해제됨"}")
    fun showOff() = println("포커스 가능!")
}
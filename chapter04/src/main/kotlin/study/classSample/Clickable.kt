package study.classSample

interface Clickable {
    fun click()
    fun showOff() = println("클릭 되었어요!") // 디폴트 메소드
}
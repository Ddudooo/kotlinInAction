package study.example.selection

enum class ColorWithPropertyAndMethod(
    val r: Int, val g: Int, val b: Int // enum 상수의 프로퍼티 정의
) {
    // 각 상수 생성시 프로퍼티 지정
    RED(255,0,0), ORANGE(255,165,0),
    YELLOW(255,255,0), GREEN(0,255,0), BLUE(0,0,255),
    INDIGO(75,0,130), VIOLET(238,130,238); //세미콜론 필수

    // enum 클래스 안에서 메소드 정의
    fun rgb() = (r * 256 + g) * 256 + b
}
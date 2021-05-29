# 클래스, 객체, 인터페이스
코틀린의 클래스와 인터페이스는 자바와는 약간 다르다

---
### 자바와 코틀린 다른점

* 인터페이스에 프로퍼티 선언이 들어갈 수 있다
* 기본적으로 `final` 이며 `public`
* 중첩클래스는 내부 클래스가 아님 → 즉, 외부 클래스에 대한 참조가 없음.
* 프로퍼티의 경우 간결한 구문도 가능하나, 필요시 접근자를 직접 정의가능
* `data` 와 같은 코틀린 컴파일러가 제공하는 표준 메소드 제공
* 코틀린 언어의 `위임 delegation` 사용시 위임 처리하는 준비 메소드도 가능
* 싱글턴, 동반 객체 `companion object` , 객체 식 `object expression` (자바의 익명 클래스) 표현시 `object` 키워드를 통한 지원

---
### 클래스 계층 정의

자바와 다른점 위주로...

### 코틀린 인터페이스 

코틀린 인터페이스는 자바 8의 인터페이스와 비슷하다

- 추상메소드, 디폴트 메소드 정의 가능
- 필드 정의 불가능

```kotlin
// 인터페이스 정의
interface Clickable {
	fun click()
}
```

```kotlin
// 인터페이스 구현
class Button: Clickable {
	override fun click() = println("클릭 가능")
}
```

자바에서는 `extends`와 `implements` 키워드로 정의하지만

코틀린에서는 `:` 붙이고 인터페이스 혹은 클래스 이름을 적는것으로 모두 처리

코틀린에서는 자바와 다르게 `override` 변경자를 반드시 사용해야함

```kotlin
// 인터페이스 선언시 메소드 본문 정의
interface Clickable {
	fun click()
	fun showOff() = println("클릭 가능") // 디폴트 구현
}
```

```kotlin
interface Focusable {
	fun setFocus(b: Boolean) =
		println("포커스 ${if (b) "ON" else "OFF"}")
	fun showOff() = println("포커스 가능")
}
```

디폴트 메소드 명칭이 같은 인터페이스를 한 클래스에서 구현 할 경우

구현 클래스에서 오버라이딩 하지 않을시 컴파일 오류 발생

```kotlin
class Button : Clickable, Focusable {
	override fun click() = println("클릭 됨!")
	override fun showOff() {
		// 상위 타입 이름을 꺽쇠 괄호 <> 사이에 넣어서 "super" 지정시
		// 어떤 상위 타입의 메소드를 호출할지 지정 가능.
		super<Clickable>.showOff() 
		super<Focusable>.showOff()
	}
}
```

자바에서는 `Clickable.super.showOff ()` 처럼 `super` 앞에 기반 타입을 적지만,

코틀린에서는 `super<Clickable>.showOff ()` 처럼 꺾쇠 괄호 안에 기반 타입 이름을 지정한다.
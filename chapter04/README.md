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

### open, final, abstract 변경자: 기본적으로 final
자바에서 `final` 로 명시적으로 상속을 금지하는 않는 모든 클래스를 다른 클래스가 상속가능하다.

기본적으로 상속이 가능한 자바 클래스로  생기는 문제로 `취약한 기반 클래스` 문제로

기반 클래스 변경으로 인한 상속클래스의 변동사항이다

기반 클래스 변경시나 기타 다른 이유로 하위 클래스 동작이 예기치 않게 바뀔수 있어 기반 클래스는 취약하다

`이펙티브 자바` 에서는

> 상속을 위한 설계와 문서를 갖추거나, 그럴 수 없다면 상속을 금지하라

이는 오버라이드를 의도한 클래스나 메소드가 아니면 `final` 로 만들라는 것.

코틀린은 이 철학을 따라, 기본적으로 클래스와 메소드 모두 `final` 이다

상속을 허용하려면 클래스 앞에 `open` 변경자를 붙여야 한다

메소드나 프로퍼티에도 오버라이드 허용하려면 `open` 변경자를 필요로 한다

```kotlin
open class RichButton: Clickable { // open 키워드로 상속에 대해 열림 선언
	fun disalbe() {} // 별다른 키워들 안붙힐시 기본적으로 final로, 하위 클래스에서 오버라이드 불가
	open fun animate() {} // open 키워드로 하위 클래스에서 오버라이드 가능
	override fun click() {} // 오버라이드 된 메소드는 기본적으로 open
// final override fun click() {} 오버라이드 메소드를 상속 금지하려면 final 키워드 추가
}
```

추상 클래스, 메소드는 자바처럼 사용할 수 있음 `abstract` 선언 후 구현 객체에서 오버라이드를 반드시 해야 함으로 `open` 변경자를 명시할 필요가 없음

![img.png](static/images/image01.png)

### 가시성 변경자: 기본적으로 공개

가시성 변경자란?

코드 기반에 있는 선언에 대한 클래스 외부 접근을 제어한다.

어떤 클래스의 구현에 대한 접근을 제한함으로써 그 클래스에 의존하는 외부 코드를
깨지 않고도 클래스 내부 구현을 변경할 수 있다.

코틀린의 기본 가시성은 자바와 다르다.
아무 변경자도 없는 경우 선언은 모두 공개다 .

또한 자바의 기본 가시성인 패키지 전용도 코틀린에 없다

코틀린에서 패키지는 네임스페이스를 관리하기 위한 용도로만 사용된다

이에 대한 대안으로 코틀린에서 `internal` 이라는 새로운 가시성 변경자 도입을 했다

다른 차이는 코틀린에서는 최상위 선언에 대해 `private` 가시성을 허용한다

최상위 선언은 클래스, 함수, 프로퍼티 등이 포함된다

![img.png](static/images/image02.png)

### 내부 클래스와 중첩된 클래스: 기본적으로 중첩 클래스

코틀린에서도 클래스 안에 다른 클래스를 선언할 수 있다

자바와의 차이점은 코틀린에서는 명시적으로 요청하지 않는 한 바깥쪽 클래스 인스턴스에 대한 접근 권한이 없다

![img.png](static/images/image03.png)

### 봉인된 클래스: 클래스 계층 정의 시 계층 확장 제한

상위클래스에 `sealed` 변경자를 붙이면

그 상위 클래스를 상속한 하위 클래스 정의를 제한할수 있다.

`sealed` 클래스의 하위 클래스를 정의할 때는 반드시 상위 클래스 안에 중첩시켜야 한다.

`sealed`로 표시된 클래스는 자동으로 `open`

![img.png](static/images/image04.png)
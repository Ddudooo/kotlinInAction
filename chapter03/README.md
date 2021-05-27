# 함수 정의와 호출
코틀린의 개선된 `함수 정의` 와 `함수 호출` 기능

`확장 함수` 와 프로퍼티를 사용 자바 라이브러리를 코틀린 스타일 적용

`확장` 을 통한 코틀린 장점 확대

---

### 코틀린에서 컬렉션 만들기

코틀린에서 컬렉션 초기화 및 선언하는 방법

**기본적으로 생성되는 컬렉션은 불변 타입**

### List

불변 리스트 - `listOf()`

가변 리스트 - `mutableListOf()` , `arrayListOf()` 등...

### Set

불변 셋 - `setOf()`

가변 셋 - `mutableSetOf()` , `hashSetOf()` , `linkedSetOf()` , `sortedSetOf()`  등...

### Map

불변 맵 - `mapOf()`

가변 맵 - `mutableMapOf()`, `hashMapOf()` , `linkedMapOf()` , `sortedMapOf()` 등...

해당 함수로 생성된 클래스는 기존 자바 콜렉션과 같은 클래스

---
### 함수를 호출하기 쉽게 만들기

자바 콜렉션에는 디폴트 `toString` 구현이 들어있음.

해당 함수 구현을  변경하기 위해서는

자바 프로젝트의 경우 `Guava` 나 `Apache Commons` 같은 서드 파티 프로젝트 추가나 직접 관련 로직 구현

코틀린의 경우, 해당 사항을 처리할 수 있는 함수를 표준 라이브러리에서 제공(?)

예시로 코틀린 직접 구현

```kotlin
fun <T> joinToString(
		collection: Collection<T>,
		separator: String,
		prefix: String,
		postfix: String
) : String {
		val result = StringBuilder(prefix)
		for ((index, element) in collection.withIndex()) {
			if(index>0) result.append(separator)
			result.append(element)
		}

		result.append(postfix)
		return result.toString()
}
```

### 이름 붙인 인자 `Named arguments`

함수 호출시 하나 이상의 인수의 이름을 지정 가능

함수에 많은 인수가 있고 `Boolean` 또는 `Value` 경우 유용

`joinToString(collection, separator = " ", prefix = " ", postfix = ".")`

### 디폴트 파라미터 `Default arguments`

코틀린에서는 함수 선언시 **파라미터의 디폴트 값**을 지정 할 수 있음

```kotlin
fun <T> joinToString(
		collection: Collection<T>,
		separator: String = ", ",
		prefix: String = "",
		postfix: String = ""
): String
```

호출시에는 이름을 생략할시, 함수 선언할 때와 같은 순서로 인자 지정

중간에 있는 인자 생략시, 지정 인자에 이름을 붙여서 지정
### 정적인 유틸리티 클래스 없애기: 최상위 함수와 프로퍼티

자바에서는 보통 모든 코드를 클래스의 메소드로 작성한다.

단순한 연산을 위해 다양한 정적 메소드를 생성하게 되는데,

생성된 정적 메소드만 모아두는 유틸리티 클래스를 생성하는 경우가 많이 생긴다.

JDK의 `Collections` 클래스가 그 예시

코틀린의 경우 해당 함수를 소스 파일의 최상위 수준, 다른 클래스 밖으로 위치시키면 된다.

해당 함수 사용시에는 함수가 정의된 패키지 임포트하면 되고

유틸리티 클래스 이름이 추가로 들어갈 필요는 없다

```kotlin
package strings

fun joinToString(/**/): String {
	// ...
}
```

```kotlin
//자바 코드의 경우
import strings.JoinKt;

public class JoinKt {
	public static String joinToString(/**/) { 
			//...
	}
}
```

코틀린 컴파일러가 생성하는 클래스 명칭은 최상위 함수가 들어 있던 코틀린 소스 파일 이름과 대응

따라서 자바 코드로 변환시 코틀린 파일의 모든 최상위 함수는 해당 클래스의 정적인 메소드가 된다.

### 최상위 프로퍼티

함수와 마찬가지로 프로퍼티도 파일의 최상위 수준에 놓을 수 있다.

보통 상수 처리하는 프로퍼티를 사용하게 되는데

자바의 경우 `public static final` 을 통해 생성한다

이와 같이 코틀린에서 사용시 `const val` 키워들 붙여서 사용시 동일하게 생성된다

다만, 원시 타입과 `String` 타입만 `const` 로 지정할 수 있다.

---
### 메소드를 다른 클래스에 추가: 확장 함수와 프로퍼티

기존 자바 API를 재작성 하지 않고도 코틀린의 편리한 기능을 사용할 수 있게 해주는 `확장 함수`

> 확장함수는 어떤 클래스의 멤버 메소드인 것처럼 호출할 수 있지만
그 클래스의 밖에 선언된 함수

선언 예시

```kotlin
package strings

fun String.lastChar(): Char = this.get(this.length-1)
// 수신 객체 멤버에 this 없이 접근 가능
fun String.lastChar(): Char = get(length-1) 
```

확장 함수를 만들려면 추가하려는 함수 이름 앞에 확장할 클래스 이름을 덧붙이면 됨

해당 클래스 이름을 `수신 객체 타입` 으로 부름

확장 함수가 호출 되는 대상이 되는 값을 `수신 객체` 라고 부름

![img.png](static/images/image01.png)

해당 함수를 호출하는 구문은 다른 일반 클래스 멤버를 호출하는 구문과 동일하다.

확장 함수 내부에서는 일반적인 인스턴스 메소드의 내부에서와 마찬가지로 수신 객체의
메소드나 프로퍼티를 바로 사용할 수 있다

하지만 확장 함수가 캡슐화를 깨지는 않는다!

클래스 내에서 정의한 메소드와 달리 확장 함수 안에서는 `private` 이나 `protected` 멤버를 사용할 수 없다

### 임포트와 확장 함수

**확장 함수를 사용하기 위해서는 그 함수를 다른 클래스나 함수와 마찬가지로 임포트해야만 한다**

`as` 키워드를 사용하면 임포트한 클래스나 함수를 다른 이름으로 부를 수 있다.

코틀린 문법상 확장 함수는 반드시 짧은 이름을 써야 한다.

따라서 임포트할 때 이름을 바꾸는 것이 확장 함수 이름 충돌로 해결할 수 있는 유일한 방법이다.

### 자바에서 확장 함수 호출

내부적으로 확장 함수는 수신 객체를 첫번째 인자로 받는 정적 메소드

**따라서 확장 함수를 호출해도 다른 어댑터 객체나 실행 시점 부가 비용이 들지 않음**

```java
//자바 코드
char c = StringUtilKt.lastChar("Java");
```
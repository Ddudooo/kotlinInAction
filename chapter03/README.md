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
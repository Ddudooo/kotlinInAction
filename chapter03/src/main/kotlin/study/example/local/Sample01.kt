package study.example.local

// 코드 중복을 보여주는 예시
class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    if (user. name. isEmpty ()) {
        throw IllegalArgumentException(
            "Can't save user $ {user, id}: empty Name")
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException (
            "Can't save user ${user.id}: empty Address")
    }
    // user 를 데이터베이스에 저장한다.
    println("saved id = ${user.id}, name= ${user.name}, address = ${user.address}")
}

fun main() {
    val createUser = User(1, "코틀린", "주소")
    saveUser(createUser)
}
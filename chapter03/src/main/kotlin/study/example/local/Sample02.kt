package study.example.local

fun saveUser2(user: User) {
    fun validate (user: User,
                  value: String,
                  fieldName : String) {
        if ( value.isEmpty() ){
            throw IllegalArgumentException (
                "Can't save user ${user.id}: empty $fieldName")
        }
    }
    // 로컬 함수를 호출해서 각 필드 검증
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
    // user 를 데이터베이스에 저장한다.
    println("saved id = ${user.id}, name= ${user.name}, address = ${user.address}")
}

fun main() {
    val createUser = User(1, "코틀린", "주소")
    saveUser2(createUser)
}
package study.example.local

fun User.validateBeforeSave() {
    fun validate (value: String, fieldName : String) {
        if ( value.isEmpty() ){
            throw IllegalArgumentException (
                // 바깥 함수의 파라미터에 직접 접근 가능
                "Can't save user $id: empty $fieldName")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
    // user 를 데이터베이스에 저장한다.
}

fun saveUser3(user: User) {
    user.validateBeforeSave()
    // user 를 데이터베이스에 저장
    println("saved id = ${user.id}, name= ${user.name}, address = ${user.address}")
}

fun main() {
    val createUser = User(1, "코틀린", "주소")
    saveUser3(createUser)
}
package study.example.func

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

fun main() {
    val list = listOf(1,2,3)
    println(joinToString(list,"; ", "(",")"))

    // 함수의 각 인자별로 이름을 호출하여, 가독성을 좀더 올려준다
    // 인자별로 어떤일을 하는 지...
    println(joinToString(list, separator = " ", prefix = " ", postfix = "."))
}
package study.example.func

//이름 충돌로 인한 변경
fun <T> joinToString2(
    collection: Collection<T>,
    separator: String= ", ",
    prefix: String = "",
    postfix: String = ""
) : String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if(index>0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}
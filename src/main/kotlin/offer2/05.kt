package offer2

fun replaceSpace(s: String): String {
    val builder = StringBuilder(s)
    var i = 0
    while (i < builder.length) {
        if (builder[i] == ' ') {
            builder[i] = '%'
            builder.insert(i+1, "20")
            i += 2
        }
        i++
    }
    return builder.toString()
}
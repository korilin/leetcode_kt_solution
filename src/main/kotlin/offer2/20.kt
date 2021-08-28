package offer2

fun isNumber(s: String): Boolean {
    var status = 0
    var i = 0
    val symbol = "+-"
    val number = "0123456789"
    val e = "eE"
    while (i < s.length) {
        val c = s[i]
        status = when (status) {
            0 -> when (c) {' ' -> 0; in symbol -> 1; '.' -> 2; in number -> 3; else -> 10 }
            1 -> when (c) {in number -> 3; '.' -> 2; else -> 10 }
            2 -> if (c in number) 5 else 10
            3 -> when (c) {in number -> 3;'.' -> 4; in e -> 6; ' ' -> 9; else -> 10 }
            4 -> when (c) {in number -> 5; in e -> 6; ' ' -> 9; else -> 10 }
            5 -> when (c) {in number -> 5; in e -> 6; ' ' -> 9; else -> 10 }
            6 -> when (c) {in symbol -> 7; in number -> 8; else -> 10 }
            7 -> if (c in number) 8 else 10
            8 -> when (c) {in number -> 8; ' ' -> 9; else -> 10 }
            else -> if (c == ' ') 9 else 10
        }
        if (status == 10) break
        i++
    }
    return status != 0 && status != 1 && status != 2 && status != 6 && status != 7 && i == s.length
}

fun main() {
    println(isNumber("-1E-16"))
}
package offer2

fun myPow(_x: Double, _n: Int): Double {
    var x = _x
    var n = if (_n < 0) {
        x = 1 / x
        -_n
    } else _n
    var res = 1.0
    while (n != 0) {
        if (n.and(1) == 1) res *= x;
        x *= x
        n = n ushr 1
    }
    return res
}

fun main() {
    val n = -2147483648;
    println(-n)
}
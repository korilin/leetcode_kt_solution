package offer2

fun fib(n: Int): Int {
    if (n < 2) return n
    var v1 = 0
    var v2 = 1
    var r = 0
    for (i in 2..n) {
        r = (v1 + v2) % 1000000007
        v1 = v2
        v2 = r
    }
    return r
}
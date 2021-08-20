package offer2

import kotlin.math.pow

fun numWays(n: Int): Int {
    if (n < 2) return 1
    var v1 = 1
    var v2 = 2
    for (i in 3..n) {
        v2 = ((v1 + v2) % 1000000007).also { v1 = v2 }
    }
    return v2
}

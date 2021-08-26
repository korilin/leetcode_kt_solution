package offer2

import kotlin.math.pow

fun printNumbers(n: Int): IntArray {
    val max = 10.0.pow(n.toDouble()).toInt();
    return Array(max - 1) { i -> i + 1 }.toIntArray()
}
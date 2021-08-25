package offer2

fun cuttingRope(n: Int): Int {
    if (n < 3) return 1
    if (n == 3) return 2
    val save = IntArray(n + 1)
    // f(0..3) 使用不切割的值
    save[0] = 0
    save[1] = 1
    save[2] = 2
    save[3] = 3
    // f(4..n)
    for (i in 4..n) {
        var max = 0 // 当前长度切一刀后乘积的最大值
        // 切一刀的长度 j = 1..i/2 和剩余长度 i-j
        for (j in 1..i / 2 + 1) {
            val pro = save[j] * save[i - j]
            if (pro > max) max = pro
        }
        save[i] = max
    }
    return save[n];
}

package offerII

class Q001 {
    fun divide(_a: Int, _b: Int): Int {
        var symbol = true
        var overflow = 0
        fun negative(x: Int) = if (x < 0) x else (0 - x).also { symbol = !symbol }

        var a = negative(_a)
        val b = negative(_b)
        var v = 0

        // 时间复杂度 O(a/b)
        if (b == -1) v = if (a == Int.MIN_VALUE) Int.MAX_VALUE.also { overflow = 1 } else -a
        else while (a <= b) {
            a -= b
            v += 1
        }

        return if (symbol) v else -v - overflow
    }
}
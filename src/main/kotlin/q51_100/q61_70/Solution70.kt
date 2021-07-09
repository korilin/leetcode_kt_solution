package q51_100.q61_70

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
class Solution70 {

    /**
     * f(x) = f(x1) + f(x2)
     *
     * f(x1) = 最后一步为 1 个台阶的个数 = f(x - 1)
     * f(x2) = 最后一步为 2 个台阶的个数 = f(x - 2)
     *
     * f(x) = f(x-1) + f(x-2)
     *
     * 矩阵快速幂
     *
     * M^n * [1, 1].h = [f(n + 1), f(n)].h
     *
     * M^n = [f(n), f(n-1)]
     */
    fun climbStairs(n: Int): Int {
        val m = arrayOf(
            arrayOf(1, 1),
            arrayOf(1, 0)
        )
        var un = n
        val r = arrayOf(
            arrayOf(1, 0),
            arrayOf(0, 1)
        )
        while (un != 0) {
            if (un.and(1) == 1) matrix(m, r, r)
            matrix(m, m, m)
            un = un shr 1
        }
        return r[0][0]
    }

    private fun matrix(x: Array<Array<Int>>, y: Array<Array<Int>>, save: Array<Array<Int>>) {
        val v1 = x[0][0] * y[0][0] + x[0][1] * y[1][0]
        val v2 = x[0][0] * y[0][1] + x[0][1] * y[1][1]
        val v3 = x[1][0] * y[0][0] + x[1][1] * y[1][0]
        val v4 = x[1][0] * y[0][1] + x[1][1] * y[1][1]
        save[0][0] = v1
        save[0][1] = v2
        save[1][0] = v3
        save[1][1] = v4
    }
}
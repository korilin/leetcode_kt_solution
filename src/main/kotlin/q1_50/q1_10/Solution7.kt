package q1_50.q1_10

/**
 * https://leetcode-cn.com/problems/reverse-integer
 */
class Solution7 {
    /**
     * Note：
     * 时间复杂度 O(n), O(1), n 为数字长度
     * Int.MAX_VALUE = 2^31 − 1 = 2147483647
     * Int.MIN_VALUE = −2^31 = -2147483648
     */
    fun reverse(x: Int): Int {
        var temp = x
        var revNum = 0
        var pop: Int
        while (temp != 0) {
            pop = temp % 10
            temp /= 10
            if (revNum > Int.MAX_VALUE / 10 || (revNum == Int.MAX_VALUE / 10 && pop > 7)) return 0
            if (revNum < Int.MIN_VALUE / 10 || (revNum == Int.MIN_VALUE / 10 && pop < -8)) return 0
            revNum = revNum * 10 + pop
        }
        return revNum
    }
}
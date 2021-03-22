/**
 * Title: 整数反转
 *
 * Description:
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 链接：https://leetcode-cn.com/problems/reverse-integer
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
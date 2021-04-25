package q1_50.q1_10

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi
 */
class Solution8 {
    /**
     * Note：
     * 时间复杂度 O(n), O(1), n 为字符串长度
     * Int.MAX_VALUE = 2^31 − 1 = 2147483647
     * Int.MIN_VALUE = −2^31 = -2147483648
     * readStatus:
     *     0 start
     *     1 signed
     *     2 number
     *     3 end
     */
    fun myAtoi(s: String): Int {
        var readStatus = 0
        var readCharInStatus = 0
        var num = 0
        var signed = 1
        var read: Int
        for (c in s) {
            readCharInStatus = if (c == ' ') 0 else if (c in "+-") 1 else if (c in "1234567890") 2 else 3
            readStatus = when (readStatus) {
                1 -> if (readCharInStatus == 2) 2 else 3
                2 -> if (readCharInStatus != 2) 3 else 2
                else -> readCharInStatus
            }
            if (readStatus == 3) break
            if (readStatus == 1 && c == '-') signed = -1
            if (readStatus == 2) {
                read = (c.toInt() - '0'.toInt()) * signed
                if (num > Int.MAX_VALUE / 10 || (num == Int.MAX_VALUE / 10 && read > 7)) return Int.MAX_VALUE
                if (num < Int.MIN_VALUE / 10 || (num == Int.MIN_VALUE / 10 && read < -8)) return Int.MIN_VALUE
                num = num * 10 + read
            }
        }
        return num
    }
}
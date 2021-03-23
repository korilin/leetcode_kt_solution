/**
 * Title: 字符串转换整数 (atoi)
 *
 * difficulty: 中等
 *
 * Description:
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 * - 读入字符串并丢弃无用的前导空格
 * - 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * - 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * - 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * - 如果整数数超过 32 位有符号整数范围 [−2^31, 2^31− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 23^1− 1 的整数应该被固定为 23^1− 1 。
 * - 返回整数作为最终结果。
 *
 * 注意：
 * - 本题中的空白字符只包括空格字符 ' ' 。
 * - 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
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
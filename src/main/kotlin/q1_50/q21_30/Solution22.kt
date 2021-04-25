package q1_50.q21_30

import java.util.*
import kotlin.text.StringBuilder

/**
 * https://leetcode-cn.com/problems/generate-parentheses
 */
class Solution22 {
    /**
     * 回溯法
     * 时间复杂度：n 个卡特兰数
     * 空间复杂度：需要 n*2 个栈帧，因此复杂度为 O(n)
     */
    fun generateParenthesis(n: Int): List<String> {
        val resultList = LinkedList<String>()
        fun generate(builder: StringBuilder, open: Int, close: Int) {
            if (open == n && close == n) {
                resultList.add(builder.toString())
            }
            if (open < n) {
                builder.append('(')
                generate(builder, open + 1, close)
                builder.deleteCharAt(builder.length - 1)
            }
            if (close < open) {
                builder.append(')')
                generate(builder, open, close + 1)
                builder.deleteCharAt(builder.length - 1)
            }
        }
        generate(StringBuilder(), 0, 0)
        return resultList
    }
}
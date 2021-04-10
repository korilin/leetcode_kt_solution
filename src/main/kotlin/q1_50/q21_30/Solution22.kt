package q1_50.q21_30

import java.lang.StringBuilder
import java.util.*

/**
 * Title: 括号生成
 *
 * difficulty: 中等
 *
 * Description:
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 */
class Solution22 {
    fun generateParenthesis(n: Int): List<String> {
        val linkedList = LinkedList<String>()
        val parenthesisBuilder = StringBuilder()
        fun getParenthesis(i:Int) {
            if (i == n) {
                linkedList.add(parenthesisBuilder.toString())
            }else{
                TODO()
            }
        }
        return linkedList
    }
}
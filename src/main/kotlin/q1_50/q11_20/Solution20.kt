package q1_50.q11_20

import java.util.*

/**
 * Title: 有效的括号
 *
 * difficulty: 简单
 *
 * Description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 *  1. 左括号必须用相同类型的右括号闭合。
 *  2. 左括号必须以正确的顺序闭合。
 *
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
class Solution20 {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for(c in s){
            when(c) {
                '(' -> stack.push(')')
                '{' -> stack.push('}')
                '[' -> stack.push(']')
                else -> {
                    if(stack.isEmpty() || stack.pop() != c) return false
                }
            }
        }
        return stack.isEmpty()
    }
}
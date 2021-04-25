package q1_50.q11_20

import java.util.*

/**
 * https://leetcode-cn.com/problems/valid-parentheses
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
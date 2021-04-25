package q1_50.q11_20

import java.util.*

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 */
class Solution17 {
    /**
     * 回溯法
     * 数字 2，3，4，5，6，8 有 3 个对应字母，假设有 m 个这个类型的数字
     * 数字 7，9 有 4 个对应字母，假设有 n 个这个类型的数字
     * 时间复杂度为 O(3^m * 4^n)
     */
    fun letterCombinations(digits: String): List<String> {
        val letters = arrayListOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        val result = LinkedList<String>()
        if (digits.isEmpty()) return result
        fun backtrack(digits: String, combination: String) {
            if (digits.isEmpty()) result.add(combination)
            else for (letter in letters[digits[0].toInt() - 48])
                backtrack(digits.substring(1), combination + letter)
        }
        backtrack(digits, "")
        return result
    }
}
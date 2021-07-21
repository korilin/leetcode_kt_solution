package q151_200.q151_160

import java.lang.StringBuilder

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
class Solution151 {
    fun reverseWords(s: String): String {
        val ls = s.trim().split(" ").reversed()
        return StringBuilder().apply {
            ls.forEach { w ->
                if (w != "") append("$w ")
            }
        }.toString().trim()
    }
}
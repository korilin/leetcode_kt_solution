package more

import java.util.*
import kotlin.Comparator

class Solution524 {
    fun findLongestWord(s: String, dictionary: List<String>): String {

        val f = Array(s.length + 1) {
            IntArray(26) { s.length }
        }

        for (i in s.length - 1 downTo 0) {
            val c = s[i]
            for (j in 0 until 26) {
                f[i][j] = if (c == 'a' + j) i
                else f[i + 1][j]
            }
        }

        Collections.sort(dictionary, Comparator { o1, o2 ->
            val dl = o2.length - o1.length
            if (dl == 0) o1.compareTo(o2)
            else dl
        })

        for (t in dictionary) {
            var i = 0
            var match = true
            for (c in t) {
                if (f[i][c - 'a'] == s.length) {
                    match = false
                    break
                } else i = f[i][c - 'a']
            }
            if (match) return t
        }
        return ""
    }
}

fun main() {
    val s = Solution524()
    println(s.findLongestWord("abpcplea", listOf("ale","apple","monkey","plea")))
}
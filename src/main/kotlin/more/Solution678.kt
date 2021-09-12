package more

class Solution678 {
    fun checkValidString(s: String): Boolean {
        var leftBracketMinNum = 0
        var leftBracketMaxNum = 0
        for (c in s) {
            when(c) {
                '(' -> {
                    leftBracketMinNum++
                    leftBracketMaxNum++
                }
                ')' -> {
                    if (leftBracketMinNum > 0) leftBracketMinNum--
                    if (leftBracketMaxNum == 0) return false
                    leftBracketMaxNum--
                }
                else -> {
                    if (leftBracketMinNum > 0) leftBracketMinNum--
                    leftBracketMaxNum++
                }
            }
        }
        return leftBracketMinNum == 0
    }
}
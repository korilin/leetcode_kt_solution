package q1_50.q1_10

/**
 * https://leetcode-cn.com/problems/palindrome-number
 */
class Solution9 {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false
        var y = x
        var revertedNumber = 0
        while (y > revertedNumber) {
            revertedNumber = revertedNumber * 10 + y % 10
            y /= 10
        }
        return revertedNumber == y || revertedNumber / 10 == y
    }
}
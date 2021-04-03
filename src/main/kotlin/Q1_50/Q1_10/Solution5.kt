package Q1_50.Q1_10

/**
 * Title: 最长回文子串
 *
 * difficulty: 中等
 *
 * Description:
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 */
class Solution5 {
    /**
     * 中心扩展，时间复杂度：O(n^2), 空间复杂度 O(1)
     */
    fun longestPalindrome(s: String): String {
        var left = 0
        var right = 0
        var result = ""
        var leftExtend = left + 1
        var rightExtend = right - 1
        while (right < s.length) {
            while ((leftExtend > 0 && rightExtend < s.length - 1) && (s[leftExtend - 1] == s[rightExtend + 1])) {
                rightExtend++
                leftExtend--
            }
            if (result.length < rightExtend - leftExtend + 1) {
                result = s.slice(leftExtend..rightExtend)
            }
            if (left < right) {
                left++
            } else {
                right++
            }
            leftExtend = left + 1
            rightExtend = right - 1
        }
        return result
    }
}
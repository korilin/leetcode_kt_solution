/**
 * Title: 无重复字符的最长子串
 *
 * Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        var continuous = ""
        for (c in s) {
            val index = continuous.indexOf(c)
            continuous = (if (index != -1) continuous.substring(index + 1) else continuous) + c
            max = if (continuous.length > max) continuous.length else max
        }
        return max
    }
}
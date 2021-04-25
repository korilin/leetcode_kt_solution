package q1_50.q1_10

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
class Solution3 {
    /**
     * 滑动窗口，只需遍历一次，时间复杂度 O(n)
     */
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
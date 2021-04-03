package q1_50.q11_20

/**
 * Title: 最长公共前缀
 *
 * difficulty: 简单
 *
 * Description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 */
class Solution14 {
    /**
     * 时间复杂度 O(nm)，n 为字符串数量，m 为最短的字符串长度
     */
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        if (strs.size == 1) return strs[0]
        var index = -1
        loop@ while (++index < strs[0].length) {
            val c = strs[0][index]
            for (str in strs) if (index >= str.length || c != str[index]) break@loop
        }
        if (index < 0) return ""
        return strs[0].substring(0, index)
    }
}
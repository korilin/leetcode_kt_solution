package q1_50.q21_30

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 */
class Solution28 {
    fun strStr(haystack: String, needle: String): Int {

        var index = 0;
        var nextIndex = index;

        while (index <= haystack.length - needle.length) {
            var search = index
            var match = 0
            while (haystack[search] == needle[match]){
                if (haystack[search] == needle[0])
                search += 1
                match += 1
            }
            index = nextIndex
        }
        return -1
    }
}
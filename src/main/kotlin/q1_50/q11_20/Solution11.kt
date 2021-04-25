package q1_50.q11_20

/**
 * https://leetcode-cn.com/problems/container-with-most-water
 */
class Solution11 {
    /**
     * 双指针，时间复杂度为 O(n)，但提交结果并不是很理想
     */
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var result = 0
        while (left < right) {
            val r = (right - left) * if (height[left] < height[right]) height[left++] else height[right--]
            if (r > result) result = r
        }
        return result
    }
}
package q1_50.q41_50

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
class Solution42 {
    fun trap(height: IntArray): Int {
        var ans = 0
        var left = 0
        var right = height.size - 1
        var leftMax = 0
        var rightMax = 0
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = maxOf(height[left], leftMax)
                ans += leftMax - height[left++]
            }else{
                rightMax = maxOf(height[right], rightMax)
                ans += rightMax - height[right--]
            }
        }
        return ans
    }
}
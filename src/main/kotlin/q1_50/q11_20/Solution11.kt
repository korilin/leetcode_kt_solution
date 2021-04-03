package q1_50.q11_20

/**
 * Title: 盛最多水的容器
 *
 * difficulty: 中等
 *
 * Description:
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在
 * 坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 *
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
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
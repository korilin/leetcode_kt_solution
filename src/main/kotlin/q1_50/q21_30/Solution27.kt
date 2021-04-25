package q1_50.q21_30

/**
 * https://leetcode-cn.com/problems/remove-element
 */
class Solution27 {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var index = 0
        for (num in nums) {
            if (num != `val`) nums[index++] = num
        }
        return index
    }
}
package q1_50.q21_30

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 */
class Solution26 {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 1) return nums.size
        var index = 1
        var preNum: Int = nums[0]
        for (move in 1 until nums.size) {
            val num = nums[move]
            if (num != preNum) nums[index++] = num
            preNum = num
        }
        return index
    }
}
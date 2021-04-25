package q1_50.q21_30

/**
 * Title: 删除有序数组中的重复项
 *
 * difficulty: 简单
 *
 * Description:
 * 给你一个有序数组 nums，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
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
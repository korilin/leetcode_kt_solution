package q1_50.q30_40

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
class Solution33 {
    fun search(nums: IntArray, target: Int): Int {
        var offset = 1
        var index = 0

        while (0 <= index && index < nums.size) {
            nums[index].also {
                when {
                    target == it -> return index
                    offset == -1 && target > it -> return -1
                    offset == 1 && target < it -> index = nums.size.also { offset = -1 }
                }
            }
            index += offset
        }
        return -1
    }
}
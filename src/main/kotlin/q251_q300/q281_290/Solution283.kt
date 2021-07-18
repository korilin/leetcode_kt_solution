package q251_q300.q281_290

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
class Solution283 {
    fun moveZeroes(nums: IntArray): Unit {
        var zeroIndex = -1
        var currentIndex = 0

        while (currentIndex < nums.size) {

            if (zeroIndex != -1 && nums[currentIndex] != 0) {
                nums[zeroIndex] = nums[currentIndex]
                nums[currentIndex] = 0
                zeroIndex++
            }

            if (zeroIndex == -1 && nums[currentIndex] == 0) {
                zeroIndex = currentIndex
            }

            currentIndex++
        }
    }
}
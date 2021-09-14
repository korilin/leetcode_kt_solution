package more

class Solution162 {
    fun findPeakElement(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val i = left + (right - left) / 2
            if (nums[i] < nums[i + 1]) {
                left = i + 1
            } else {
                right = i
            }
        }
        return left
    }
}
package q1_50.q11_20

/**
 * https://leetcode-cn.com/problems/3sum-closest
 */
class Solution16 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        fun abs(num: Int): Int = if (num < 0) -num else num
        nums.sort()
        var result = nums[0] + nums[1] + nums[2]
        var i1 = -1
        var i2: Int
        var i3: Int
        while (++i1 < nums.size - 2) {
            i2 = i1 + 1
            i3 = nums.size - 1
            while (i2 < i3) {
                val sum = nums[i1] + nums[i2] + nums[i3]
                if (abs(sum - target) < abs(result - target)) result = sum
                if (sum < target) i2++
                else if (sum > target) i3--
                else return result
            }
        }
        return result
    }
}
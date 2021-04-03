package q1_50.q11_20

/**
 * Title: 三数之和
 *
 * difficulty: 中等
 *
 * Description:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 链接：https://leetcode-cn.com/problems/3sum
 */
class Solution15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        nums.sort()
        for (i1 in nums.indices) {
            if (nums[i1] > 0) break
            if (i1 > 0 && nums[i1] == nums[i1 - 1]) continue
            var i2 = i1 + 1
            var i3 = nums.size - 1
            while (i2 < i3) {
                when {
                    nums[i1] + nums[i2] + nums[i3] > 0 -> while (i2 < --i3) if (nums[i3] != nums[i3 + 1]) break
                    nums[i1] + nums[i2] + nums[i3] < 0 -> while (++i2 < i3) if (nums[i2] != nums[i2 - 1]) break
                    else -> {
                        result.add(listOf(nums[i1], nums[i2], nums[i3]))
                        while (++i2 < i3) if (nums[i2] != nums[i2 - 1]) break
                    }
                }
            }
        }
        return result
    }
}
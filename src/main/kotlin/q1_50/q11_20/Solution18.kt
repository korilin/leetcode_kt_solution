package q1_50.q11_20

import java.util.*

/**
 * Title: 四数之和
 *
 * difficulty: 中等
 *
 * Description:
 * 给你一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在三个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。。
 *
 * 链接：https://leetcode-cn.com/problems/4sum
 */
class Solution18 {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = LinkedList<List<Int>>()
        if(nums.size < 4) return result
        nums.sort()
        val n = nums.size
        for (i1 in 0 until n - 3) {
            if (i1 > 0 && nums[i1] == nums[i1 - 1]) continue
            if (nums[i1] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue
            if (nums[i1] + nums[i1 + 1] + nums[i1 + 2] + nums[i1 + 3] > target) break
            for (i2 in i1 + 1 until n - 2) {
                if (i2 > i1 + 1 && nums[i2] == nums[i2 - 1]) continue
                if (nums[i1] + nums[i2] + nums[n - 1] + nums[n - 2] < target) continue
                if (nums[i1] + nums[i2] + nums[i2 + 1] + nums[i2 + 2] > target) break
                var i3 = i2 + 1
                var i4 = n - 1
                while (i3 < i4) {
                    if (i3 > i2 + 1 && nums[i3] == nums[i3 - 1]) {
                        i3++
                        continue
                    }
                    if (i4 < n - 1 && nums[i4] == nums[i4 + 1]) {
                        i4--
                        continue
                    }
                    when {
                        nums[i1] + nums[i2] + nums[i3] + nums[i4] < target -> i3++
                        nums[i1] + nums[i2] + nums[i3] + nums[i4] > target -> i4--
                        else -> result.add(listOf(nums[i1], nums[i2], nums[i3++], nums[i4]))
                    }
                }
            }
        }
        return result
    }
}
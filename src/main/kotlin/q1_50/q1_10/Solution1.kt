package q1_50.q1_10

/**
 * https://leetcode-cn.com/problems/two-sum
 */
class Solution1 {
    /**
     * 使用哈希表的 key 来进行匹配，时间复杂度 O(n)
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap = HashMap<Int, Int>()
        for ((index, num) in nums.withIndex()) {
            val get = hashMap[target - num]
            if (get != null) {
                return intArrayOf(get, index)
            }
            hashMap[num] = index
        }
        return intArrayOf()
    }
}
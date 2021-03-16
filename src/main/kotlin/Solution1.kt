class Solution1 {
    /**
     * 使用哈希表来进行匹配，时间复杂度 O(n)
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
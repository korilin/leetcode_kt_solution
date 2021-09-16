package offer2

fun majorityElement(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    val half = nums.size / 2
    for (num in nums) {
        val count = map.getOrDefault(num, 0) + 1
        if (count > half) return num
        map[num] = count
    }
    return 0
}
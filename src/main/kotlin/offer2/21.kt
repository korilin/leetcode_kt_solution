package offer2

fun exchange(nums: IntArray): IntArray {
    var right = 0
    var left = nums.size - 1
    while (right < left) {
        val v = nums[right]
        if (v and 1 == 0) {
            nums[right] = nums[left]
            nums[left] = v
            left--
        } else right++
    }
    return nums
}

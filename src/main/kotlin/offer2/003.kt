package offer2

fun findRepeatNumber(nums: IntArray): Int {
    var i = 0
    while (i < nums.size) {
        val v = nums[i]
        if (v != i) {
            val temp = nums[v]
            if (temp != v){
                nums[v] = v
                nums[i] = temp
            }
            else return v
        }else {
            i++
        }
    }
    return -1
}
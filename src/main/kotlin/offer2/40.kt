package offer2

fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
    arr.sort()
    val nums = IntArray(k)
    for (i in 0 until k) {
        nums[i] = arr[i]
    }
    return nums
}
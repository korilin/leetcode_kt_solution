package q1_50.q1_10

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
class Solution4 {
    /**
     * 更好的解题思路请查看官方解题
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
     */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val length = nums1.size + nums2.size
        var middle = 0
        var middlePre = 0
        var index1 = 0
        var index2 = 0
        var index = 0
        while (index <= length / 2) {
            middlePre = middle
            if (index1 <= nums1.size - 1 && index2 <= nums2.size - 1) {
                if (nums1[index1] <= nums2[index2]) {
                    middle = nums1[index1]
                    index1++
                } else {
                    middle = nums2[index2]
                    index2++
                }
            } else if (index1 <= nums1.size - 1) {
                middle = nums1[index1]
                index1++
            } else if (index2 <= nums2.size - 1) {
                middle = nums2[index2]
                index2++
            }
            index++
        }
        if (length % 2 == 1) {
            middlePre = middle
        }
        return (middlePre + middle) / 2.0
    }
}
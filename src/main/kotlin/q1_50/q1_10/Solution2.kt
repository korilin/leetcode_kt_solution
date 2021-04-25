package q1_50.q1_10

/**
 * https://leetcode-cn.com/problems/add-two-numbers
 */
class Solution2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2
        var sum: Int
        var carry = 0
        val l3 = ListNode(0)
        var now: ListNode? = null
        while (node1 != null || node2 != null || carry == 1) {
            sum = (node1?.`val` ?: 0) + (node2?.`val` ?: 0) + carry
            carry = sum / 10
            now = if (now == null) {
                l3.also {  l3.`val` = sum  % 10 }
            } else {
                ListNode(sum % 10).also { now!!.next = it }
            }
            node1 = node1?.next
            node2 = node2?.next
        }
        return l3
    }

    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}


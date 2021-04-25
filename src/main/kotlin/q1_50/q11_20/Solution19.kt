package q1_50.q11_20

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 */
class Solution19 {
    /**
     * 前后指针，时间复杂度 O(n)，空间复杂度 (1)
     */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val node = ListNode(0)
        node.next = head
        var first = head
        var second = node
        var i = 0
        while (first != null) {
            first = first.next
            if (i++ >= n) second = second.next!!
        }
        second.next = second.next?.next
        return node.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}


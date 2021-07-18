package q101_150.q141_150

/**
 * https://leetcode-cn.com/problems/reorder-list/
 */
class Solution143 {
    fun reorderList(head: ListNode): Unit {
        val middle = middleNode(head)
        var l1: ListNode? = head
        var l2: ListNode? = reverseList(middle.next)
        middle.next = null
        while (l1 != null && l2 != null) {
            val temp1 = l1.next
            val temp2 = l2.next
            l1.next = l2
            l1 = temp1
            l2.next = l1
            l2 = temp2
        }
    }

    private fun middleNode(head: ListNode): ListNode {
        var slow = head
        var fast = head
        while (fast.next != null && fast.next!!.next != null) {
            slow = slow.next!!
            fast = fast.next!!.next!!
        }
        return slow
    }

    private fun reverseList(head: ListNode?): ListNode? {
        var h: ListNode? = null
        var current = head
        var next: ListNode?
        while (current != null) {
            next = current.next
            current.next = h
            h = current
            current = next
        }
        return h
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
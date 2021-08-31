package q201_250.q201_210

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
class Solution206 {
    fun reverseList(head: ListNode?): ListNode? {
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
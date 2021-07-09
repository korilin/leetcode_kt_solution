package q101_150.q141_150

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
class Solution141 {

    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head?.next ?: return false
        while (slow != fast) {
            slow = slow?.next
            fast = fast.next?.next ?: return false
        }
        return true
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
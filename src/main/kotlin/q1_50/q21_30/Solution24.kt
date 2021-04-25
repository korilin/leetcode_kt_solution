package q1_50.q21_30

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs
 */
class Solution24 {
    fun swapPairs(head: ListNode?): ListNode? {
        var moveNode = ListNode(0)
        moveNode.next = head
        val headPre = moveNode
        while (moveNode.next?.next != null) {
            val node1 = moveNode.next
            val node2 = node1!!.next
            node1.next = node2!!.next
            node2.next = node1
            moveNode.next = node2
            moveNode = node1
        }
        return headPre.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
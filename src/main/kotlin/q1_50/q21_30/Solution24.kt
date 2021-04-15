package q1_50.q21_30

/**
 * Title: 两两交换链表中的节点
 *
 * difficulty: 中等
 *
 * Description:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
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
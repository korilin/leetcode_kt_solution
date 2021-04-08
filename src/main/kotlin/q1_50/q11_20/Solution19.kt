package q1_50.q11_20

/**
 * Title: 删除链表的倒数第 N 个结点
 *
 * difficulty: 中等
 *
 * Description:
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？。
 *
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 */
class Solution19 {
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
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
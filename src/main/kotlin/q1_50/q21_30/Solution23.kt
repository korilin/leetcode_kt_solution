package q1_50.q21_30

import java.util.*

/**
 * Title: 合并K个升序链表
 *
 * difficulty: 困难
 *
 * Description:
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 */
class Solution23 {
    /**
     * 优先队列
     * 时间复杂度：与分治合并算法一样都是 O(kn×log(k))
     */
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val nodePriorityQueue = PriorityQueue<ListNode> { a, b ->  a.`val` - b.`val`}
        for (node in lists) {
            node?.let { nodePriorityQueue.add(node) }
        }
        val head = ListNode(0)
        var tail = head
        while (nodePriorityQueue.isNotEmpty()) {
            tail.next = nodePriorityQueue.poll()
            tail = tail.next!!
            tail.next?.let { nodePriorityQueue.add(it) }
        }
        return head.next
    }

    /*
     * 分治合并算法
     */
    fun mergeKLists0(lists: Array<ListNode?>): ListNode? {
        fun mergeTwoLinked(n1:ListNode?, n2:ListNode?): ListNode? {
            val head = ListNode(0)
            var tail = head
            var node1 = n1
            var node2 = n2
            while (node1!=null || node2!=null) {
                if (node2 == null || (node1!=null && node1.`val` <= node2.`val`)) {
                    tail.next = node1
                    node1 = node1!!.next
                }else{
                    tail.next = node2
                    node2 = node2.next
                }
                tail = tail.next!!
            }
            return head.next
        }

        fun merging(ls: Array<ListNode?>): ListNode? {
            if (ls.size == 1) return ls[0]
            val mergeArray = arrayOfNulls<ListNode>(if (ls.size % 2 == 0) ls.size / 2 else ls.size / 2 + 1)
            var i = 0
            while (i < ls.size) {
                if (i == ls.size - 1) mergeArray[i / 2] = ls[i]
                else {
                    mergeTwoLinked(ls[i], ls[i+1])?.let { mergeArray[i / 2] = it }
                }
                i += 2
            }
            return merging(mergeArray)
        }
        if (lists.isEmpty()) return null
        return merging(lists)
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
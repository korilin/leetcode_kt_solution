
### 21. 合并两个有序链表

链接：https://leetcode-cn.com/problems/merge-two-sorted-lists

```Kotlin
class Solution21 {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2
        val head = ListNode(0)
        var node = head
        while (node1!=null && node2!= null) {
            if (node1.`val` <= node2.`val`) {
                node.next = node1
                node1 = node1.next
            }else{
                node.next = node2
                node2 = node2.next
            }
            node = node.next!!
        }
        while (node1 != null) {
            node.next = node1
            node1 = node1.next
            node = node.next!!
        }
        while (node2 !=null) {
            node.next = node2
            node2 = node2.next
            node = node.next!!
        }
        return head.next
    }
}
```

### 22. 括号生成

链接：https://leetcode-cn.com/problems/generate-parentheses

```Kotlin
class Solution22 {
    /**
     * 回溯法
     * 时间复杂度：n 个卡特兰数
     * 空间复杂度：需要 n*2 个栈帧，因此复杂度为 O(n)
     */
    fun generateParenthesis(n: Int): List<String> {
        val resultList = LinkedList<String>()
        fun generate(builder: StringBuilder, open: Int, close: Int) {
            if (open == n && close == n) {
                resultList.add(builder.toString())
            }
            if (open < n) {
                builder.append('(')
                generate(builder, open + 1, close)
                builder.deleteCharAt(builder.length - 1)
            }
            if (close < open) {
                builder.append(')')
                generate(builder, open, close + 1)
                builder.deleteCharAt(builder.length - 1)
            }
        }
        generate(StringBuilder(), 0, 0)
        return resultList
    }
}
```

### 23. 合并K个升序链表

链接：https://leetcode-cn.com/problems/merge-k-sorted-lists

```Kotlin
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
}
```

### 24. 两两交换链表中的节点

链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs

```Kotlin
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
}
```

### 25. K 个一组翻转链表

链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group

```Kotlin
class Solution25 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        return null
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
```

### 26. 删除有序数组中的重复项

链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array

```Kotlin
class Solution26 {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 1) return nums.size
        var index = 1
        var preNum: Int = nums[0]
        for (move in 1 until nums.size) {
            val num = nums[move]
            if (num != preNum) nums[index++] = num
            preNum = num
        }
        return index
    }
}
```


### 27. 移除元素

链接：https://leetcode-cn.com/problems/remove-element

```Kotlin
class Solution27 {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var index = 0
        for (num in nums) {
            if (num != `val`) nums[index++] = num
        }
        return index
    }
}
```

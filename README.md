# leetcode_kt_solution
 使用Kotlin在LeetCode上刷的题目

## 项目相关

- 构建工具：Gradle
- Kotlin版本：1.4.31
- JDK：1.8

## 题目

<details>
<summary>1. 两数之和</summary>

### 两数之和

给定一个整数数组 `nums` 和一个整数目标值 `target`，请你在该数组中找出 **和为目标值** 的那 **两个** 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

你可以按任意顺序返回答案。

链接：https://leetcode-cn.com/problems/two-sum

```Kotlin
class Solution1 {
    /**
     * 使用哈希表的key来进行匹配，时间复杂度 O(n)
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap = HashMap<Int, Int>()
        for ((index, num) in nums.withIndex()) {
            val get = hashMap[target - num]
            if (get != null) {
                return intArrayOf(get, index)
            }
            hashMap[num] = index
        }
        return intArrayOf()
    }
}
```
</details>

<details>
<summary>2. 两数相加</summary>

### 两数相加

给你两个 **非空** 的链表，表示两个非负的整数。它们每位数字都是按照 **逆序** 的方式存储的，并且每个节点只能存储 **一位** 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

链接：https://leetcode-cn.com/problems/add-two-numbers

```Kotlin
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
}
```
</details>

<details>
<summary>模板</summary>

### 题目

description

```Kotlin
code
```
</details>
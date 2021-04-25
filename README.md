# leetcode_kt_solution
 使用Kotlin在LeetCode上刷的题目

## 项目相关

- 构建工具：Gradle
- Kotlin版本：1.4.31
- JDK：1.8

本仓库所有题目均来自 **[力扣（LeetCode）](https://leetcode-cn.com/problemset/all/)**

所有记录的解题代码均成功通过 LeetCode 的提交执行，但不记录提交的执行时间和内存消耗（因为这不是重点）

## 未完成题目

| 题号 | 题目 |
| -- | -- |
| 10 | 正则表达式匹配 |
| 25 | K 个一组翻转链表 |

## 题目

### 1. 两数之和

链接：https://leetcode-cn.com/problems/two-sum

```Kotlin
class Solution1 {
    /**
     * 使用哈希表的 key 来进行匹配，时间复杂度 O(n)
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


### 2. 两数相加

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

### 3. 无重复字符的最长子串

链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters

```Kotlin
class Solution3 {
    /**
     * 滑动窗口，只需遍历一次，时间复杂度 O(n)
     */
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        var continuous = ""
        for (c in s) {
            val index = continuous.indexOf(c)
            continuous = (if (index != -1) continuous.substring(index + 1) else continuous) + c
            max = if (continuous.length > max) continuous.length else max
        }
        return max
    }
}
```

### 4. 寻找两个正序数组的中位数

链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays

```Kotlin
class Solution4 {
    /**
     * 更好的解题思路请查看官方解题
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
     */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val length = nums1.size + nums2.size
        var middle = 0
        var middlePre = 0
        var index1 = 0
        var index2 = 0
        var index = 0
        while (index <= length / 2) {
            middlePre = middle
            if (index1 <= nums1.size - 1 && index2 <= nums2.size - 1) {
                if (nums1[index1] <= nums2[index2]) {
                    middle = nums1[index1]
                    index1++
                } else {
                    middle = nums2[index2]
                    index2++
                }
            } else if (index1 <= nums1.size - 1) {
                middle = nums1[index1]
                index1++
            } else if (index2 <= nums2.size - 1) {
                middle = nums2[index2]
                index2++
            }
            index++
        }
        if (length % 2 == 1) {
            middlePre = middle
        }
        return (middlePre + middle) / 2.0
    }
}
```

### 5. 最长回文子串

链接：https://leetcode-cn.com/problems/longest-palindromic-substring

```Kotlin
class Solution5 {
    /**
     * 中心扩展，时间复杂度：O(n^2), 空间复杂度 O(1)
     */
    fun longestPalindrome(s: String): String {
        var left = 0
        var right = 0
        var result = ""
        var leftExtend = left + 1
        var rightExtend = right - 1
        while (right < s.length) {
            while ((leftExtend > 0 && rightExtend < s.length - 1) && (s[leftExtend - 1] == s[rightExtend + 1])) {
                rightExtend++
                leftExtend--
            }
            if (result.length < rightExtend - leftExtend + 1) {
                result = s.slice(leftExtend..rightExtend)
            }
            if (left < right) {
                left++
            } else {
                right++
            }
            leftExtend = left + 1
            rightExtend = right - 1
        }
        return result
    }
}
```


### 6. Z 字形变换

链接：https://leetcode-cn.com/problems/zigzag-conversion

```Kotlin
class Solution6 {
    fun convert(s: String, numRows: Int): String {
        val builderList = LinkedList<StringBuilder>()
        for (row in 0 until numRows) {
            builderList.add(row, StringBuilder())
        }
        var direction = true
        var index = 0
        for (c in s) {
            builderList[index].append(c)
            if (index + 1 < numRows && (direction || (!direction && index - 1 < 0))) {
                index++
                direction = true
            } else if (index - 1 >= 0) {
                index--
                direction = false
            }
        }
        val resultStringBuilder = StringBuilder();
        for (row in 0 until numRows) {
            resultStringBuilder.append(builderList[row].toString())
        }
        return resultStringBuilder.toString();
    }
}
```

### 7. 整数反转

链接：https://leetcode-cn.com/problems/reverse-integer

```Kotlin
class Solution7 {
    /**
     * Note：
     * 时间复杂度 O(n), O(1), n 为数字长度
     * Int.MAX_VALUE = 2^31 − 1 = 2147483647
     * Int.MIN_VALUE = −2^31 = -2147483648
     */
    fun reverse(x: Int): Int {
        var temp = x
        var revNum = 0
        var pop: Int
        while (temp != 0) {
            pop = temp % 10
            temp /= 10
            if (revNum > Int.MAX_VALUE / 10 || (revNum == Int.MAX_VALUE / 10 && pop > 7)) return 0
            if (revNum < Int.MIN_VALUE / 10 || (revNum == Int.MIN_VALUE / 10 && pop < -8)) return 0
            revNum = revNum * 10 + pop
        }
        return revNum
    }
}
```

### 8. 字符串转换整数 (atoi)

链接：https://leetcode-cn.com/problems/string-to-integer-atoi

```Kotlin
/**
 * Note：
 * 时间复杂度 O(n), O(1), n 为字符串长度
 * Int.MAX_VALUE = 2^31 − 1 = 2147483647
 * Int.MIN_VALUE = −2^31 = -2147483648
 * readStatus:
 *     0 start
 *     1 signed
 *     2 number
 *     3 end
 */
fun myAtoi(s: String): Int {
    var readStatus = 0
    var readCharInStatus = 0
    var num = 0
    var signed = 1
    var read: Int
    for (c in s) {
        readCharInStatus = if (c == ' ') 0 else if (c in "+-") 1 else if (c in "1234567890") 2 else 3
        readStatus = when (readStatus) {
            1 -> if (readCharInStatus == 2) 2 else 3
            2 -> if (readCharInStatus != 2) 3 else 2
            else -> readCharInStatus
        }
        if (readStatus == 3) break
        if (readStatus == 1 && c == '-') signed = -1
        if (readStatus == 2) {
            read = (c.toInt() - '0'.toInt()) * signed
            if (num > Int.MAX_VALUE / 10 || (num == Int.MAX_VALUE / 10 && read > 7)) return Int.MAX_VALUE
            if (num < Int.MIN_VALUE / 10 || (num == Int.MIN_VALUE / 10 && read < -8)) return Int.MIN_VALUE
            num = num * 10 + read
        }
    }
    return num
}
```

### 9. 回文数

链接：https://leetcode-cn.com/problems/palindrome-number

```Kotlin
class Solution9 {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false
        var y = x
        var revertedNumber = 0
        while (y > revertedNumber) {
            revertedNumber = revertedNumber * 10 + y % 10
            y /= 10
        }
        return revertedNumber == y || revertedNumber / 10 == y
    }
}
```

### 10. 正则表达式匹配

链接：https://leetcode-cn.com/problems/regular-expression-matching

```Kotlin
class Solution10 {
    /**
     * 做不出
     */
    fun isMatch(s: String, p: String): Boolean {
        TODO()
    }
}
```

### 11. 盛最多水的容器

链接：https://leetcode-cn.com/problems/container-with-most-water

```Kotlin
class Solution11 {
    /**
     * 双指针，时间复杂度为 O(n)，但提交结果并不是很理想
     */
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var result = 0
        while (left < right) {
            val r = (right - left) * if (height[left] < height[right]) height[left++] else height[right--]
            if (r > result) result = r
        }
        return result
    }
}
```

### 12. 整数转罗马数字

链接：https://leetcode-cn.com/problems/integer-to-roman

```Kotlin
class Solution12 {
    /**
     * 外层 while 循环执行次数总为 13
     * 内层 while 由于 % 运算的特性也有固定执行上限
     * 因此时间复杂度为 O(1)
     */
    fun intToRoman(num: Int): String {
        val romanChars = arrayListOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        val romanPeripheryList = arrayListOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val result = StringBuffer()
        var number = num
        var peripheryIndex = 0
        var romanCharCount: Int
        while (peripheryIndex < romanPeripheryList.size) {
            romanCharCount = number / romanPeripheryList[peripheryIndex]
            number %= romanPeripheryList[peripheryIndex]
            while (romanCharCount-- != 0)
                result.append(romanChars[peripheryIndex])
            peripheryIndex++
        }
        return result.toString()
    }
}
```

### 13. 罗马数字转整数

链接：https://leetcode-cn.com/problems/roman-to-integer

```Kotlin
class Solution13 {
    /**
     * 时间复杂度 O(n)
     */
    fun romanToInt(s: String): Int {
        fun getNum(i: Int) = when(s[i]){
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            else -> 1000
        }
        var sum = 0
        var pre = getNum(0)
        var index = 1
        var num:Int
        while(index < s.length){
            num = getNum(index++)
            sum += if (pre < num) -pre else pre
            pre = num
        }
        return sum+pre
    }
}
```

### 14. 最长公共前缀

链接：https://leetcode-cn.com/problems/longest-common-prefix

```Kotlin
class Solution14 {
    /**
     * 时间复杂度 O(nm)，n 为字符串数量，m 为最短的字符串长度
     */
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        if (strs.size == 1) return strs[0]
        var index = -1
        loop@ while (++index < strs[0].length) {
            val c = strs[0][index]
            for (str in strs) if (index >= str.length || c != str[index]) break@loop
        }
        if (index < 0) return ""
        return strs[0].substring(0, index)
    }
}
```

### 15. 三数之和

链接：https://leetcode-cn.com/problems/3sum

```Kotlin
class Solution15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        nums.sort()
        for (i1 in nums.indices) {
            if (nums[i1] > 0) break
            if (i1 > 0 && nums[i1] == nums[i1 - 1]) continue
            var i2 = i1 + 1
            var i3 = nums.size - 1
            while (i2 < i3) {
                when {
                    nums[i1] + nums[i2] + nums[i3] > 0 -> while (i2 < --i3) if (nums[i3] != nums[i3 + 1]) break
                    nums[i1] + nums[i2] + nums[i3] < 0 -> while (++i2 < i3) if (nums[i2] != nums[i2 - 1]) break
                    else -> {
                        result.add(listOf(nums[i1], nums[i2], nums[i3]))
                        while (++i2 < i3) if (nums[i2] != nums[i2 - 1]) break
                    }
                }
            }
        }
        return result
    }
}
```

### 16. 最接近的三数之和

链接：https://leetcode-cn.com/problems/3sum-closest

```Kotlin
class Solution16 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        fun abs(num: Int): Int = if (num < 0) -num else num
        nums.sort()
        var result = nums[0] + nums[1] + nums[2]
        var i1 = -1
        var i2: Int
        var i3: Int
        while (++i1 < nums.size - 2) {
            i2 = i1 + 1
            i3 = nums.size - 1
            while (i2 < i3) {
                val sum = nums[i1] + nums[i2] + nums[i3]
                if (abs(sum - target) < abs(result - target)) result = sum
                if (sum < target) i2++
                else if (sum > target) i3--
                else return result
            }
        }
        return result
    }
}
```

### 17. 电话号码的字母组合

链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number

```Kotlin
class Solution17 {
    /**
     * 回溯法
     * 数字 2，3，4，5，6，8 有 3 个对应字母，假设有 m 个这个类型的数字
     * 数字 7，9 有 4 个对应字母，假设有 n 个这个类型的数字
     * 时间复杂度为 O(3^m * 4^n)
     */
    fun letterCombinations(digits: String): List<String> {
        val letters = arrayListOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        val result = LinkedList<String>()
        if (digits.isEmpty()) return result
        fun backtrack(digits: String, combination: String) {
            if (digits.isEmpty()) result.add(combination)
            else for (letter in letters[digits[0].toInt() - 48])
                backtrack(digits.substring(1), combination + letter)
        }
        backtrack(digits, "")
        return result
    }
}
```

### 18. 四数之和

链接：https://leetcode-cn.com/problems/4sum

```Kotlin
class Solution18 {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = LinkedList<List<Int>>()
        if(nums.size < 4) return result
        nums.sort()
        val n = nums.size
        for (i1 in 0 until n - 3) {
            if (i1 > 0 && nums[i1] == nums[i1 - 1]) continue
            if (nums[i1] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue
            if (nums[i1] + nums[i1 + 1] + nums[i1 + 2] + nums[i1 + 3] > target) break
            for (i2 in i1 + 1 until n - 2) {
                if (i2 > i1 + 1 && nums[i2] == nums[i2 - 1]) continue
                if (nums[i1] + nums[i2] + nums[n - 1] + nums[n - 2] < target) continue
                if (nums[i1] + nums[i2] + nums[i2 + 1] + nums[i2 + 2] > target) break
                var i3 = i2 + 1
                var i4 = n - 1
                while (i3 < i4) {
                    if (i3 > i2 + 1 && nums[i3] == nums[i3 - 1]) {
                        i3++
                        continue
                    }
                    if (i4 < n - 1 && nums[i4] == nums[i4 + 1]) {
                        i4--
                        continue
                    }
                    when {
                        nums[i1] + nums[i2] + nums[i3] + nums[i4] < target -> i3++
                        nums[i1] + nums[i2] + nums[i3] + nums[i4] > target -> i4--
                        else -> result.add(listOf(nums[i1], nums[i2], nums[i3++], nums[i4]))
                    }
                }
            }
        }
        return result
    }
}
```

### 19. 删除链表的倒数第 N 个结点

链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list

```Kotlin
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
```

### 20. 有效的括号

链接：https://leetcode-cn.com/problems/valid-parentheses

```Kotlin
class Solution20 {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for(c in s){
            when(c) {
                '(' -> stack.push(')')
                '{' -> stack.push('}')
                '[' -> stack.push(']')
                else -> {
                    if(stack.isEmpty() || stack.pop() != c) return false
                }
            }
        }
        return stack.isEmpty()
    }
}
```

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


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

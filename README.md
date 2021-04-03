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

## 题目

<details>
<summary>1. 两数之和</summary>

### 两数之和

给定一个整数数组 `nums` 和一个整数目标值 `target`，请你在该数组中找出 **和为目标值** 的那 **两个** 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

你可以按任意顺序返回答案。

- 难度：简单
- 链接：https://leetcode-cn.com/problems/two-sum

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
</details>

<details>
<summary>2. 两数相加</summary>

### 两数相加

给你两个 **非空** 的链表，表示两个非负的整数。它们每位数字都是按照 **逆序** 的方式存储的，并且每个节点只能存储 **一位** 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

- 难度：中等
- 链接：https://leetcode-cn.com/problems/add-two-numbers

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
<summary>3. 无重复字符的最长子串</summary>

### 无重复字符的最长子串

给定一个字符串，请你找出其中不含有重复字符的 **最长子串** 的长度。

- 难度：中等
- 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters

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
</details>

<details>
<summary>4. 寻找两个正序数组的中位数</summary>

### 寻找两个正序数组的中位数

给定两个大小分别为 `m` 和 `n` 的正序（从小到大）数组 `nums1` 和 `nums2`。请你找出并返回这两个正序数组的 **中位数**。

- 难度：困难
- 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays

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
</details>

<details>
<summary>5. 最长回文子串</summary>

### 最长回文子串

给你一个字符串 `s`，找到 `s` 中最长的回文子串。

- 难度：中等
- 链接：https://leetcode-cn.com/problems/longest-palindromic-substring

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
</details>

<details>
<summary>6. Z 字形变换</summary>

### Z 字形变换

将一个给定字符串 `s` 根据给定的行数 `numRows` ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 `"PAYPALISHIRING"` 行数为 `3` 时，排列如下：

```Text
P   A   H   N
A P L S I I G
Y   I   R
```
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：`"PAHNAPLSIIGYIR"`。

- 难度：中等
- 链接：https://leetcode-cn.com/problems/zigzag-conversion

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
</details>

<details>
<summary>7. 整数反转</summary>

### 整数反转

给你一个 32 位的有符号整数 `x` ，返回将 `x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 `[−2^31, 2^31− 1]` ，就返回 0。

**假设环境不允许存储 64 位整数（有符号或无符号）。**

- 难度：简单
- 链接：https://leetcode-cn.com/problems/reverse-integer

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
</details>

<details>
<summary>8. 字符串转换整数 (atoi)</summary>

### 字符串转换整数 (atoi)

请你来实现一个`myAtoi(string s)` 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。

函数 `myAtoi(string s)` 的算法如下：
- 读入字符串并丢弃无用的前导空格
- 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
- 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
- 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
- 如果整数数超过 32 位有符号整数范围 `[−2^31, 2^31− 1]` ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 `−2^31` 的整数应该被固定为 `−2^31` ，大于` 2^31− 1` 的整数应该被固定为 `2^31− 1` 。
- 返回整数作为最终结果。

注意：
- 本题中的空白字符只包括空格字符 `' '` 。
- 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。


- 难度：中等
- 链接：https://leetcode-cn.com/problems/string-to-integer-atoi

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
</details>

<details>
<summary>9. 回文数</summary>

### 回文数

给你一个整数 `x` ，如果 `x` 是一个回文整数，返回 `true` ；否则，返回 `false` 。

回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，`121` 是回文，而 `123` 不是。

- 难度：
- 链接：https://leetcode-cn.com/problems/palindrome-number

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
</details>

<details>
<summary>10. 正则表达式匹配</summary>

### 正则表达式匹配

给你一个字符串 `s` 和一个字符规律 `p` ，请你来实现一个支持 `'.'` 和 `'*'` 的正则表达式匹配。

- `'.'` 匹配任意单个字符
- `'*'` 匹配零个或多个前面的那一个元素

所谓匹配，是要涵盖 **整个** 字符串 `s` 的，而不是部分字符串。
  
- 难度：困难
- 链接：https://leetcode-cn.com/problems/regular-expression-matching

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
</details>

<details>
<summary>11. 盛最多水的容器</summary>

### 盛最多水的容器

给你 `n` 个非负整数 `a1，a2，...，an`，每个数代表坐标中的一个点`(i, ai)` 。

在坐标内画 `n` 条垂直线，垂直线 `i` 的两个端点分别为 `(i, ai)` 和 `(i, 0)`。

找出其中的两条线，使得它们与 `x` 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器。

- 难度：中等
- 链接：https://leetcode-cn.com/problems/container-with-most-water

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
</details>

<details>
<summary>12. 整数转罗马数字</summary>

### 整数转罗马数字

罗马数字包含以下七种字符： `I`， `V`， `X`， `L`，`C`，`D` 和 `M`。

```
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

例如， 罗马数字 2 写做 `II`，即为两个并列的 1。12 写做 `XII`，即为 `X` + `II`。 27 写做 `XXVII`, 即为 `XX` + `V` + `II`。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 `IIII`，而是 `IV`。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 `IX`。

这个特殊的规则只适用于以下六种情况：

- `I` 可以放在 `V`(5) 和 `X`(10) 的左边，来表示 4 和 9。
- `X` 可以放在 `L`(50) 和 `C`(100) 的左边，来表示 40 和 90。
- `C` 可以放在 `D`(500) 和 `M`(1000) 的左边，来表示 400 和 900。

给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

- 难度：中等
- 链接：https://leetcode-cn.com/problems/integer-to-roman

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
</details>

<details>
<summary>13. 罗马数字转整数</summary>

### 罗马数字转整数

罗马数字包含以下七种字符： `I`， `V`， `X`， `L`，`C`，`D` 和 `M`。

```
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

例如， 罗马数字 2 写做 `II`，即为两个并列的 1。12 写做 `XII`，即为 `X` + `II`。 27 写做 `XXVII`, 即为 `XX` + `V` + `II`。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 `IIII`，而是 `IV`。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 `IX`。

这个特殊的规则只适用于以下六种情况：

- `I` 可以放在 `V`(5) 和 `X`(10) 的左边，来表示 4 和 9。
- `X` 可以放在 `L`(50) 和 `C`(100) 的左边，来表示 40 和 90。
- `C` 可以放在 `D`(500) 和 `M`(1000) 的左边，来表示 400 和 900。

给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

- 难度：简单
- 链接：https://leetcode-cn.com/problems/roman-to-integer

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
</details>

<details>
<summary>14. 最长公共前缀</summary>

### 最长公共前缀

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 `""`。

- 难度：简单
- 链接：https://leetcode-cn.com/problems/longest-common-prefix

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
</details>

<details>
<summary>15. 三数之和</summary>

### 三数之和

给你一个包含 `n` 个整数的数组 `nums`，判断 `nums` 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

- 难度：中等
- 链接：https://leetcode-cn.com/problems/3sum

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
</details>

<details>
<summary>模板</summary>

### 题目

description

- 难度：
- 链接：

```Kotlin
code
```
</details>
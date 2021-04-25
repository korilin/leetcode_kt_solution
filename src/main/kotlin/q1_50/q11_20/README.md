
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

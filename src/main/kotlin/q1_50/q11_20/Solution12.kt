package q1_50.q11_20

/**
 * https://leetcode-cn.com/problems/integer-to-roman
 */
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
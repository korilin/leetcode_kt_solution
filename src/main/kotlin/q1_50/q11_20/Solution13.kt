package q1_50.q11_20

/**
 * https://leetcode-cn.com/problems/roman-to-integer
 */
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
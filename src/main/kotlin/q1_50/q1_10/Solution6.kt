package q1_50.q1_10

import java.util.*
/**
 * https://leetcode-cn.com/problems/zigzag-conversion
 */
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
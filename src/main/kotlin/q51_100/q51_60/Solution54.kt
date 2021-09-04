package q51_100.q51_60

import java.util.*

class Solution54 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var top = 0
        var bottom = matrix.size - 1
        if (bottom < 0) return listOf()
        var left = 0
        var right = matrix[0].size - 1
        if (right < 0) return listOf()
        var x = 0
        var y = 0
        val res = LinkedList<Int>()
        var direction = 1
        while (x in left..right && y in top..bottom) {
            res.add(matrix[y][x])
            when (direction) {
                1 -> if (x == right) {
                    direction = 2
                    top++
                    y++
                } else x++
                2 -> if (y == bottom) {
                    direction = 3
                    right--
                    x--
                } else y++
                3 -> if (x == left) {
                    direction = 4
                    bottom--
                    y--
                } else x--
                4 -> if (y == top) {
                    direction = 1
                    left++
                    x++
                } else y--
            }
        }
        return res
    }
}
package offer2


fun spiralOrder(matrix: Array<IntArray>): IntArray {
    var top = 0
    var bottom = matrix.size - 1
    if (bottom < 0) return intArrayOf()
    var left = 0
    var right = matrix[0].size - 1
    if (right < 0) return intArrayOf()
    var x = 0
    var y = 0
    val res = IntArray((bottom + 1) * (right + 1))
    var i = 0
    var direction = 1
    while (x in left..right && y in top..bottom) {
        res[i] = matrix[y][x]
        i++
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
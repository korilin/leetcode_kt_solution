package offer2

fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
    var x = matrix.size - 1
    while (0 <= x) {
        val matrixI = matrix[x]
        for (temp in matrixI) {
            if (temp == target) return true
            if (temp > target) break
        }
        x -= 1
    }
    return false
}
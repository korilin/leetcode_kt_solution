package more

class Solution1894 {
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        val n = chalk.size - 1
        if (chalk[0] > k) return 0
        for (index in 1..n) {
            chalk[index] += chalk[index - 1]
            if (chalk[index] > k) return index
        }
        val remain = k % chalk[n]
        var left = 0
        var right = n
        while (left < right) {
            val middle = left + (right - left) / 2
            if (chalk[middle] <= remain) left = middle + 1
            else right = middle
        }
        return left
    }
}

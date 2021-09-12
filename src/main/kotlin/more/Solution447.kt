package more

class Solution447 {

    private val counts = HashMap<Int, Int>()

    fun numberOfBoomerangs(points: Array<IntArray>): Int {
        var ans = 0
        for (p1 in points) {
            for (p2 in points) {
                val distance = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1])
                val count = counts[distance] ?:0
                counts[distance] = count + 1
            }
            for ((_, cnt) in counts) {
                ans += cnt * (cnt - 1)
            }
            counts.clear()
        }
        return ans
    }
}

package q501_550.q501_510

import java.util.*

class Solution502 {
    fun findMaximizedCapital(k: Int, _w: Int, profits: IntArray, capital: IntArray): Int {
        var w = _w
        val projects = MutableList(profits.size) { i -> arrayOf(capital[i], profits[i]) }
        projects.sortBy { ints -> ints[0] }
        val pQueue = PriorityQueue<Int>() { p1, p2 -> p2 - p1 }
        var current = 0
        repeat(k) {
            while (current < projects.size && projects[current][0] <= w){
                pQueue.add(projects[current++][1])
            }
            if (pQueue.isEmpty()) return@repeat
            w += pQueue.poll()
        }
        return w
    }
}

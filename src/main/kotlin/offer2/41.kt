package offer2

import java.util.*

class MedianFinder() {

    /** initialize your data structure here. */
    private val smaller = PriorityQueue<Int>()
    private val bigger = PriorityQueue<Int>() { o1, o2 -> o2 - o1 }

    fun addNum(num: Int) {
        if (smaller.size > bigger.size) {
            smaller.add(num)
            bigger.add(smaller.poll())
        } else {
            bigger.add(num)
            smaller.add(bigger.poll())
        }
    }

    fun findMedian(): Double? = if (smaller.size == 0) null
    else if (smaller.size > bigger.size) smaller.peek().toDouble()
    else {
        val a = smaller.peek()
        val b = bigger.peek()
        a + (b - a) / 2.0
    }
}

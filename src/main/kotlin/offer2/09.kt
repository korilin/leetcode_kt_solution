package offer2

import java.util.*


class CQueue() {

    private val inQueue = LinkedList<Int>() as Deque<Int>
    private val outQueue = LinkedList<Int>() as Deque<Int>

    fun appendTail(value: Int) {
        inQueue.push(value)
    }

    fun deleteHead(): Int {
        if (outQueue.isEmpty()) {
            while (inQueue.isNotEmpty()) {
                outQueue.add(inQueue.removeLast())
            }
        }
        return if (outQueue.isEmpty()) -1 else outQueue.pop()
    }

}
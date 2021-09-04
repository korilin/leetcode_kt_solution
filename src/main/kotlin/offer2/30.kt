package offer2

import java.util.*

class MinStack() {

    /** initialize your data structure here. */
    private val stack = LinkedList<Int>() as Deque<Int>
    private val minStack = LinkedList<Int>() as Deque<Int>

    fun push(x: Int) {
        stack.push(x)
        if (minStack.isEmpty() || minStack.peek() >= x)
            minStack.push(x)
    }

    fun pop() {
        val v = stack.pop()
        if (minStack.peek() == v) minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun min(): Int {
        return minStack.peek()
    }
}
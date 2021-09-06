package offer2

import java.util.*

fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
    var i = 0
    val stack = LinkedList<Int>() as Deque<Int>
    for (v in pushed) {
        stack.push(v)
        while (stack.isNotEmpty() && stack.peek() == popped[i]) {
            i++
            stack.pop()
        }
    }
    return i == popped.size
}

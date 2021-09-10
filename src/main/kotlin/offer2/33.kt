package offer2

import java.util.*

fun verifyPostorder(postorder: IntArray): Boolean {
    var index = postorder.size - 1
    if (index < 0) return true
    var max = Int.MAX_VALUE
    val roots = LinkedList<Int>() as Deque<Int>
    roots.push(postorder[index])
    while (--index >= 0) {
        val value = postorder[index]
        if (value > max) return false
        while (roots.isNotEmpty() && roots.peek() > value)
            max = roots.pop()
        roots.push(value)
    }
    return true
}

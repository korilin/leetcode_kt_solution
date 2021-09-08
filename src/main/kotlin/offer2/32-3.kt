package offer2

import java.util.*

fun levelOrder3(root: TreeNode?): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    val queue = LinkedList<TreeNode>() as Deque<TreeNode>
    root?.let { queue.offer(root) }
    var positive = true

    while (queue.isNotEmpty()) {
        val temp = List(queue.size) {
            val node = queue.poll()
            node.left?.let { queue.offer(it) }
            node.right?.let { queue.offer(it) }
            node.`val`
        }
        res.add(if (positive) temp else temp.reversed())
        positive = !positive
    }

    return res
}

package offer2

import java.util.*

fun levelOrder1(root: TreeNode?): IntArray {
    val queue = LinkedList<TreeNode>() as Queue<TreeNode>
    root?.let { queue.offer(it) }
    val res = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        res.add(node.`val`)
        node.left?.let { queue.offer(it) }
        node.right?.let { queue.offer(it) }
    }
    return res.toIntArray()
}

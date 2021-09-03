package offer2

import java.util.*

fun mirrorTree(root: TreeNode?): TreeNode? {
    val queue = LinkedList<TreeNode>() as Queue<TreeNode>
    root?.let { queue.offer(it) }
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        val left = node.left?.also { queue.offer(it) }
        val right = node.right?.also { queue.offer(it) }
        node.left = right
        node.right = left
    }
    return root
}
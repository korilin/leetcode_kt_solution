package offer2

import java.util.*

fun pathSum(root: TreeNode?, target: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    fun dfs(node: TreeNode, path: LinkedList<Int>, sum: Int) {
        val v = node.`val`
        val newSum = sum + v
        path.add(v)
        if (node.left != null || node.right != null) {
            node.left?.let { dfs(it, LinkedList(path), newSum) }
            node.right?.let { dfs(it, LinkedList(path), newSum) }
        } else if (newSum == target) res.add(path)
    }
    root?.let { dfs(it, LinkedList(), 0) }
    return res
}

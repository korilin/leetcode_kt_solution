package offer2

import java.util.*

/**
 * n：A 树的节点数
 * m：B 树的节点数
 *
 * 1. 直接遍历树进行匹配
 * 用广度遍历来对 A 每一个节点（子树），对每一个节点使用 dfs 进行结构匹配
 * 时间复杂度 O(n*m)
 *
 * 2. 转换
 * 用递归得到两颗树的前序遍历字符串
 * 用 kmp 算法进行匹配
 * 前序遍历 n + m
 * kmp 算法遍历 n 次
 * 时间复杂度 O(2n+m)
 */
fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
    if (A == null || B == null) return A == null && B == null
    val queue = LinkedList<TreeNode>() as Queue<TreeNode>
    queue.offer(A)
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        if (dfs(node, B)) return true
        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
    }
    return false
}

fun dfs(node1: TreeNode?, node2: TreeNode?): Boolean = if (node2 == null) true
else if (node1 == null || node1.`val` != node2.`val`) false
else dfs(node1.left, node2.left) && dfs(node1.right, node2.right)


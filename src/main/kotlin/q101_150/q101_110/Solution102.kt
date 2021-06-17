package q101_150.q101_110

import kotlin.collections.ArrayDeque

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
class Solution102 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val resultList = mutableListOf<List<Int>>()
        root ?: return resultList
        val nodeQueue = ArrayDeque<TreeNode>()
        nodeQueue.add(root)
        var size = nodeQueue.size
        while (size != 0) {
            val values = mutableListOf<Int>()
            repeat(size) {
                val node = nodeQueue.removeFirst()
                values.add(node.`val`)
                node.left?.let { nodeQueue.add(it) }
                node.right?.let { nodeQueue.add(it) }
            }
            size = nodeQueue.size
            resultList.add(values)
        }
        return resultList
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
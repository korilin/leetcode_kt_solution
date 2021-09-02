package offer2

import java.util.*
import kotlin.math.pow

/**
 * 队列广度遍历 + 栈对称匹配
 */
fun isSymmetric(root: TreeNode?): Boolean {

    fun compare(left: TreeNode?, right: TreeNode?): Boolean = if (left == null && right == null) true
    else if (left == null || right == null || left.`val` != right.`val`) false
    else compare(left.left, right.right) && compare(left.right, right.left)

    return root?.let { compare(it.left, it.right) } ?: true
}


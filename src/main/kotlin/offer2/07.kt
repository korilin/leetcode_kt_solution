package offer2

import java.util.*

// [3, 9, 8, 5, 4, 10, 20, 15, 7]
// [4, 5, 8, 10, 9, 3, 15, 20, 7]
fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) return null
    val stack = LinkedList<TreeNode>()
    var preIndex = 0
    var inIndex = 0
    val root = TreeNode(preorder[preIndex++])
    stack.addLast(root)
    while (preIndex <= preorder.size) {
        val newNode = TreeNode(preorder[preIndex++])
        if (stack.last.`val` != inorder[inIndex]) {
            stack.last.left = newNode
        } else {
            var lastOutStack: TreeNode
            do {
                lastOutStack = stack.removeLast()
                inIndex++
            } while (stack.lastOrNull()?.`val` == inorder[inIndex])
            lastOutStack.right = newNode
        }
        stack.addLast(newNode)
    }
    return root
}

// 递归版本
fun buildTreeWithStack(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) return null
    val head = preorder[0]
    val node = TreeNode(head)
    val i = inorder.indexOf(head)
    node.left = buildTreeWithStack(
        preorder.sliceArray(1..i),
        inorder.sliceArray(0 until i)
    )
    node.right = buildTreeWithStack(
        preorder.sliceArray(i + 1 until preorder.size),
        inorder.sliceArray(i + 1 until preorder.size)
    )
    return node
}
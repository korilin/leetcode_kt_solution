package offer2;

public class O36 {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int _val) {
            val = _val;
        }
    }

    Node head = null, last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        last.right = head;
        head.left = last;
        return head;
    }

    public void dfs(Node node) {
        if (node.left != null) dfs(node.left);
        if (last != null) {
            last.right = node;
            node.left = last;
        } else head = node;
        last = node;
        if (node.right != null) dfs(node.right);
    }
}

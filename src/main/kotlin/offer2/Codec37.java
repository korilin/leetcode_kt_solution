package offer2;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Codec37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (sb.length() > 0) sb.append('|');
            if (node == null) {
                sb.append('_');
            } else {
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("\\|");
        TreeNode root = null;
        if (!data.equals("")) root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);

        for (int i = 1; i < values.length; i++) {
            String value = values[i];
            TreeNode node;
            if (i % 2 == 1) {
                node = queue.peek();
                assert node != null;
                if (!value.equals("_")) {
                    TreeNode left = new TreeNode(Integer.parseInt(value));
                    node.left = left;
                    queue.add(left);
                }
            } else {
                node = queue.poll();
                assert node != null;
                if (!value.equals("_")) {
                    TreeNode right = new TreeNode(Integer.parseInt(value));
                    node.right = right;
                    queue.add(right);
                }
            }
        }
        return root;
    }
}

package offer2;


public class O35 {
     public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        if (head == null) return null;

        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }

        for (Node node = head; node != null; node = node.next.next) {
            Node random = node.random;
            node.next.random = random == null ? null : random.next;
        }

        Node newHead = head.next;
        for (Node node = head; node != null; node = node.next) {
            // 回置原链表指针
            Node newNode = node.next;
            node.next = newNode.next;
            newNode.next = newNode.next == null ? null : newNode.next.next;
        }

        return newHead;
    }
}
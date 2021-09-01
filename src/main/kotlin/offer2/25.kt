package offer2

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var node1 = l1
    var node2 = l2
    val head = ListNode(0)
    var node = head
    while (node1!=null && node2!= null) {
        if (node1.`val` <= node2.`val`) {
            node.next = node1
            node1 = node1.next
        }else{
            node.next = node2
            node2 = node2.next
        }
        node = node.next!!
    }
    while (node1 != null) {
        node.next = node1
        node1 = node1.next
        node = node.next!!
    }
    while (node2 !=null) {
        node.next = node2
        node2 = node2.next
        node = node.next!!
    }
    return head.next
}
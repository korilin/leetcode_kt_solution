package offer2

fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
    var h = head;
    var pre:ListNode? = null
    var current = head;
    while (current != null) {
        if (current.`val` == `val`) {
            if (pre == null) h = current.next
            else pre.next = current.next
            break
        }
        pre = current
        current = current.next
    }
    return h
}
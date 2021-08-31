package offer2

fun reverseList(head: ListNode?): ListNode? {
    var h: ListNode? = null
    var current = head
    var next: ListNode?

    while (current != null) {
        next = current.next
        current.next = h
        h = current
        current = next
    }

    return h
}
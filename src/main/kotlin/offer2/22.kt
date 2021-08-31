package offer2

fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
    var current = head ?: return null
    var latter = head
    repeat(k) { latter = latter!!.next ?: return current }
    while (latter != null) {
        current = current.next!!
        latter = latter!!.next
    }
    return current
}

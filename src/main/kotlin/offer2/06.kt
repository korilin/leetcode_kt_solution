package offer2


fun reversePrint(head: ListNode?): IntArray {
    val result = mutableListOf<Int>()
    var current = ListNode(0).apply {
        next = head
    }
    while (current.next != null) {
        current = current.next!!
        result.add(0, current.`val`)
    }
    return result.toIntArray()
}
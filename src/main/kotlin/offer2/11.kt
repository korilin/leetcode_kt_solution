package offer2

fun minArray(numbers: IntArray): Int {
    var left = 0
    var right = numbers.size - 1

    while (left < right) {
        val index = (right - left) / 2 + left
        numbers[index].also {
            // it 可能与 nums -> left 相等，我们无法判断 it 处于哪个区间，和 left 比较并没有意义
            // 因此选择 right 为比较值
            if (it < numbers[right]) right = index
            // 防止 index == left 陷入死循环
            // nums -> left 比 it 大时，取下一位可以缩短一步，当越入旋转区间时，直接变成让下一次条件判断进入 else
            else if (it > numbers[right]) left = index + 1
            else right--
        }
    }

    return numbers[right]
}

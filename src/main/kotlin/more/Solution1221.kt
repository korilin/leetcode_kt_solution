package more

class Solution1221 {
    /**
     * 1. 只有字符串长度为偶数的时候才有可能平衡
     * 2. 分割的字符长度越小，数量越多，最短的长度为 2，即 LR 或 RL
     * 3. 从拆分的角度上，截取一个平衡字符串出来，不会影响到整体的拆分结果，如 RLRRLLRLRL 可以拆分成
     *    - 从前面从短截取：RL + RRLLRLRL = RL + RRLL + RLRL = RL + RRLL + RL + RL = 4
     *    - 直接截取一个大的：RLRRLLRL + RL = RLRRLL + RL + RL = RL + RRLL + RL + RL = 4
     *    - 从中间截取：RL + RRLLRL + RL = RL + ( R + RLLR + L ) + RL = RL + R+ RL + LR + L + RL = 4
     *
     * 所以，从头计算 R 和 L 的数量就可以了，只要存在 R 和 L 数量可相互抵消的字串，则结果 + 1
     */
    fun balancedStringSplit(s: String): Int {
        var offset = 0
        var res = 0
        for (c in s) {
            offset += if (c == 'L') 1 else -1
            if (offset == 0) res++
        }
        return res
    }
}
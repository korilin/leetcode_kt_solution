class NO46 {

    fun permute(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()

        fun dfs(nums: MutableList<Int>, ansOne: MutableList<Int>) {
            if (nums.isEmpty()) {
                ans.add(ansOne.toList())
                return
            }
            for ((index, num) in nums.withIndex()) {
                val numCopy = mutableListOf<Int>()
                numCopy.addAll(nums)
                numCopy.removeAt(index)
                ansOne.add(num)
                dfs(numCopy, ansOne)
                ansOne.remove(num)
            }
        }

        dfs(nums.toMutableList(), mutableListOf())
        return ans
    }
}
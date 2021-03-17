import org.junit.jupiter.api.Test

class Test {

    @Test
    fun test3(){
        val solution3 = Solution3()
        val r = solution3.lengthOfLongestSubstring("abcabcbb")
        println(r)
    }

    @Test
    fun test4(){
        val solution4 = Solution4()
        val r = solution4.findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2))
        println(r)
    }
}
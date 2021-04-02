import org.junit.jupiter.api.Test
import java.util.*

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

    @Test
    fun test5(){
        val solution5 = Solution5()
        val r = solution5.longestPalindrome("cbbd")
        println(r)
    }

    @Test
    fun test8(){
        val solution8 = Solution8()
        println(solution8.myAtoi("42"))
        println(solution8.myAtoi("  428www"))
        println(solution8.myAtoi("   -42"))
        println(solution8.myAtoi("abc123"))
        println(solution8.myAtoi("91283472332"))
        println(solution8.myAtoi("-91283472332"))
    }


    @Test
    fun test9(){
        val solution9 = Solution9()
        println(solution9.isPalindrome(121))
    }

    @Test
    fun test10(){
        val solution10 = Solution10()
        println(solution10.isMatch("aaa", "a*a"))
    }
}
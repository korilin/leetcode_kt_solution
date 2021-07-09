import q1_50.q1_10.Solution8
import org.junit.jupiter.api.Test
import q1_50.q1_10.*
import q1_50.q11_20.*
import q1_50.q21_30.Solution23
import q51_100.q61_70.Solution70
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

    @Test
    fun test16(){
        val solution16 = Solution16()
        println(solution16.threeSumClosest(intArrayOf(-100, -98, -2, -1), -101))
    }

    @Test
    fun test20(){
        val solution20 = Solution20()
        println(solution20.isValid("({})"))
    }

    @Test
    fun test23(){
        val solution23 = Solution23()
        val h1 = Solution23.ListNode(1)
        h1.next = Solution23.ListNode(4)
        h1.next!!.next = Solution23.ListNode(5)
        val h2 = Solution23.ListNode(1)
        h2.next = Solution23.ListNode(3)
        h2.next!!.next = Solution23.ListNode(4)
        val h3 = Solution23.ListNode(2)
        h3.next = Solution23.ListNode(6)
        println(solution23.mergeKLists(arrayOf(h1, h2, h3)))
    }

    @Test
    fun test70(){
        val solution70 = Solution70()
        println(solution70.climbStairs(1))
        println(solution70.climbStairs(2))
        println(solution70.climbStairs(3))
        println(solution70.climbStairs(4))
        println(solution70.climbStairs(5))
        println(solution70.climbStairs(6))
        println(solution70.climbStairs(7))
    }
}
package offer2

fun exist(board: Array<CharArray>, word: String): Boolean {
    val maxN = board.size
    val maxM = board[0].size

    fun search(n:Int, m:Int, i:Int) : Boolean{
        if (i == word.length) return true
        if (n < 0 || n >= maxN || m < 0 || m >= maxM || board[n][m] != word[i]) return false
        board[n][m] = '/'
        val res = search(n+1, m, i+1) || search(n-1, m, i+1) || search(n, m+1,i+1) || search(n,m-1,i+1)
        board[n][m] = word[i]
        return res
    }

    for(n in board.indices)
        for (m in board[0].indices)
            if (search(n,m,0)) return true

    return false
}


fun main() {
    val c = arrayOf(
        charArrayOf('a', 'b')
    )
    val s = "ba"
    println(exist(c, s))
}

package offer2

fun permutation(s: String): Array<String> {

    val join = s.toCharArray()
    val res = mutableListOf<String>()

    fun dfs(_i: Int) {
        if (_i == join.size) res.add(String(join))
        val set = HashSet<Char>()
        for (i in _i until s.length) {
            if (set.contains(join[i])) continue
            join[_i] = join[i].also { join[i] = join[_i] }
            set.add(join[_i])
            dfs(_i + 1)
            join[_i] = join[i].also { join[i] = join[_i] }
        }
    }

    dfs(0)
    return res.toTypedArray()
}

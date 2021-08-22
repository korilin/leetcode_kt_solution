package offer2

fun movingCount(m: Int, n: Int, k: Int): Int {

    val vis = Array(m) { _m ->
        Array(n) { _n ->
            var mTemp = _m
            var nTemp = _n
            var c = 0
            while (mTemp != 0 || nTemp != 0) {
                c += mTemp % 10 + nTemp % 10
                mTemp /= 10
                nTemp /= 10
            }
            c > k
        }
    }


    fun check(_m: Int, _n: Int): Int {
        if (_m < 0 || _m >= m || _n < 0 || _n >= n || vis[_m][_n]) return 0
        vis[_m][_n] = true
        return 1 + check(_m - 1, _n) + check(_m + 1, _n) + check(_m, _n + 1) + check(_m, _n - 1)
    }

    return check(0, 0)
}

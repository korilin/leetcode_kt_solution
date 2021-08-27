package offer2

fun isMatch(s: String, p: String): Boolean {
    return if (s.isEmpty())
        p.isEmpty() || (p.length >= 2 && p[1] == '*' && isMatch(s, p.substring(2)))
    else if (p.length >= 2 && p[1] == '*')
        isMatch(s, p.substring(2)) || ((p[0] == '.' || s[0] == p[0]) && isMatch(s.substring(1), p))
    else if (p.isNotEmpty() && (p[0] == '.' || p[0] == s[0]))
        isMatch(s.substring(1), p.substring(1))
    else false
}

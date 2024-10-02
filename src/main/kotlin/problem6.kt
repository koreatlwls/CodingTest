private lateinit var arr: Array<Int>
private var n = 0
private var m = 0

private fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    arr = Array(n + 1) { i -> i }

    dfs(1, 0, "")
}

private fun dfs(idx: Int, len: Int, str: String) {
    if (len == m) {
        println(str)
        return
    }

    for (i in idx..n) {
        if (len == 0) {
            dfs(i, 1, arr[i].toString())
        } else {
            dfs(i, len + 1, "$str ${arr[i]}")
        }
    }
}
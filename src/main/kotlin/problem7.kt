private lateinit var visited: Array<Boolean>
private lateinit var arr: List<Int>
private var n = 0
private var m = 0

private fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    arr = readLine().split(" ").map { it.toInt() }.sorted()
    visited = Array(n) { false }
    dfs(0, 0, "")
}

private fun dfs(idx: Int, len: Int, str: String) {
    if (len == m) {
        println(str)
        return
    }

    for (i in 0 until n) {
        if (!visited[i]) {
            visited[i] = true
            if (len == 0) {
                dfs(i, 1, arr[i].toString())
            } else {
                dfs(i, len + 1, "$str ${arr[i]}")
            }
            visited[i] = false
        }
    }
}
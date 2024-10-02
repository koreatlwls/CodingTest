private var n = 0
private var m = 0
private lateinit var arr: List<Int>

private fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    n = input[0]; m = input[1]
    arr = readLine().split(" ").map { it.toInt() }.sorted()
    dfs(0,0, "")
}

private fun dfs(idx : Int, len: Int, str: String) {
    if (len == m) {
        println(str)
        return
    }

    var temp = 0
    for (i in idx until n) {
        if (temp != arr[i]) {
            temp = arr[i]
            if (len == 0) {
                dfs(i,1, arr[i].toString())
            } else {
                dfs(i,len + 1, "$str ${arr[i]}")
            }
        }
    }
}
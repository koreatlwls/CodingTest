package nadongbin.dfsbfs

// 음료수 얼려 먹기

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private lateinit var map: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private var n = 0
private var m = 0

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine(), " ")
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    map = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }

    repeat(n) { idx ->
        map[idx] = readLine().toCharArray().map { it - '0' }.toIntArray()
    }

    var answer = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 0 && visited[i][j].not()) {
                dfs(i, j)
                answer++
            }
        }
    }

    println(answer)
}

private fun dfs(row: Int, col: Int) {
    if (row in 0 until n && col in 0 until m && visited[row][col].not() && map[row][col] == 0) {
        visited[row][col] = true

        dfs(row + 1, col)
        dfs(row - 1, col)
        dfs(row, col + 1)
        dfs(row, col - 1)
    } else {
        return
    }
}

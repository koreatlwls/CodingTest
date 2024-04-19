package dijkstra

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val dr = arrayOf(0, 0, -1, 1)
    val dc = arrayOf(-1, 1, 0, 0)

    val t = br.readLine().toInt()
    repeat(t) {
        val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
        val map = Array(n) { IntArray(m) }
        val visited = Array(n) { BooleanArray(m) }
        var answer = 0

        val bfs: (row: Int, col: Int) -> Unit = { row, col ->
            val queue = ArrayDeque<Pair<Int, Int>>()
            queue.add(Pair(row, col))
            visited[row][col] = true

            while (queue.isNotEmpty()) {
                val now = queue.removeLast()

                for (i in 0 until 4) {
                    val nextRow = now.first + dr[i]
                    val nextCol = now.second + dc[i]

                    if (nextRow in 0 until n && nextCol in 0 until m && !visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                        queue.add(Pair(nextRow, nextCol))
                        visited[nextRow][nextCol] = true
                    }
                }
            }
        }

        repeat(k) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }

            map[b][a] = 1
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j)
                    answer++
                }
            }
        }

        println(answer)
    }
}
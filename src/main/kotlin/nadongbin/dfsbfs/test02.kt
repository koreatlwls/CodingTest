package nadongbin.dfsbfs

// 미로 탈출

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var n = 0
private var m = 0
private lateinit var map: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private val dr = arrayOf(-1, 1, 0, 0)
private val dc = arrayOf(0, 0, -1, 1)

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine(), " ")
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    map = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }

    repeat(n) { idx ->
        map[idx] = readLine().toCharArray().map { it - '0' }.toIntArray()
    }

    println(bfs(0, 0))
}

private fun bfs(row: Int, col: Int): Int {
    visited[row][col] = true
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    queue.add(Triple(row, col, 1))

    while (queue.isNotEmpty()) {
        val now = queue.poll()
        if (now.first == n - 1 && now.second == m - 1) {
            return now.third
        }

        for (i in 0 until 4) {
            val nextRow = now.first + dr[i]
            val nextCol = now.second + dc[i]

            if (nextRow in 0 until n && nextCol in 0 until m && visited[nextRow][nextCol].not() && map[nextRow][nextCol] == 1) {
                visited[nextRow][nextCol] = true
                queue.add(Triple(nextRow, nextCol, now.third + 1))
            }
        }
    }

    return -1
}

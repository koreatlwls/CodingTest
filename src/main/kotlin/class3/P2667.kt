package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val result = mutableListOf<Int>()
private lateinit var arr: Array<CharArray>
private lateinit var visited: Array<BooleanArray>
private var n = 0

private val dr = arrayOf(0, 0, -1, 1)
private val dc = arrayOf(-1, 1, 0, 0)

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()

    arr = Array(n) { CharArray(n) }
    visited = Array(n) { BooleanArray(n) { false } }

    repeat(n) { idx ->
        arr[idx] = readLine().toCharArray()
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j] && arr[i][j] == '1') {
                result.add(bfs(i, j))
            }
        }
    }

    println(result.size)
    result.sorted().forEach {
        println(it)
    }
}

private fun bfs(row: Int, col: Int): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(row, col))
    visited[row][col] = true
    var count = 1

    while (queue.isNotEmpty()) {
        val (a, b) = queue.poll()

        for (i in 0 until 4) {
            val nr = a + dr[i]
            val nc = b + dc[i]

            if (nr in 0 until n && nc in 0 until n && !visited[nr][nc] && arr[nr][nc] == '1') {
                queue.add(Pair(nr, nc))
                visited[nr][nc] = true
                count++
            }
        }
    }

    return count
}

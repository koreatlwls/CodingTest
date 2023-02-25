package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private val dr = arrayOf(-1, 1, 0, 0)
private val dc = arrayOf(0, 0, -1, 1)

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (m, n) = readLine().split(" ").map { it.toInt() }

    arr = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }

    repeat(n) { idx ->
        arr[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (arr[i][j] == 1) {
                queue.add(Pair(i, j))
            }
        }
    }

    while (queue.isNotEmpty()) {
        val now = queue.poll()

        for (i in 0 until 4) {
            val nr = now.first + dr[i]
            val nc = now.second + dc[i]

            if (nr in arr.indices && nc in arr[0].indices && arr[nr][nc] == 0 && !visited[nr][nc]) {
                queue.add(Pair(nr, nc))
                arr[nr][nc] = arr[now.first][now.second] + 1
                visited[nr][nc] = true
            }
        }
    }

    println(checkResult())
}

private fun checkResult(): Int {
    var max = 0

    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (arr[i][j] == 0) {
                return -1
            }

            max = max(max, arr[i][j])
        }
    }

    return max - 1
}

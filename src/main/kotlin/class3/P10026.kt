package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var n = 0
private lateinit var graph: Array<CharArray>
private lateinit var visited: Array<BooleanArray>
private lateinit var redVisited: Array<BooleanArray>
private var answer = 0
private var redAnswer = 0
private val dr = arrayOf(-1, 1, 0, 0)
private val dc = arrayOf(0, 0, -1, 1)

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()

    graph = Array(n) { CharArray(n) }
    visited = Array(n) { BooleanArray(n) }
    redVisited = Array(n) { BooleanArray(n) }

    repeat(n) { idx ->
        graph[idx] = readLine().toCharArray()
    }

    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (!visited[i][j]) {
                bfs(i, j)
                answer++
            }
            if (!redVisited[i][j]) {
                redBfs(i, j)
                redAnswer++
            }
        }
    }

    print("$answer $redAnswer")
}

private fun bfs(row: Int, col: Int) {
    val value = graph[row][col]
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(row, col))
    visited[row][col] = true

    while (queue.isNotEmpty()) {
        val now = queue.poll()

        for (i in 0 until 4) {
            val nr = dr[i] + now.first
            val nc = dc[i] + now.second

            if (nr in 0 until n && nc in 0 until n && !visited[nr][nc] && graph[nr][nc] == value) {
                visited[nr][nc] = true
                queue.add(Pair(nr, nc))
            }
        }
    }
}

private fun redBfs(row: Int, col: Int) {
    val value = graph[row][col]
    redVisited[row][col] = true
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(row, col))

    while (queue.isNotEmpty()) {
        val now = queue.poll()

        for (i in 0 until 4) {
            val nr = dr[i] + now.first
            val nc = dc[i] + now.second

            if (nr in 0 until n && nc in 0 until n && !redVisited[nr][nc]) {
                when (value) {
                    'R' -> if (graph[nr][nc] == 'B') continue
                    'G' -> if (graph[nr][nc] == 'B') continue
                    else -> if (value != graph[nr][nc]) continue
                }

                redVisited[nr][nc] = true
                queue.add(Pair(nr, nc))
            }
        }
    }
}

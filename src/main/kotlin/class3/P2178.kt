package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var arr: Array<CharArray>
private lateinit var visited: Array<BooleanArray>
private val dr = arrayOf(-1, 1, 0, 0)
private val dc = arrayOf(0, 0, -1, 1)
private var N = 0
private var M = 0

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m

    arr = Array(n) { CharArray(m) }
    visited = Array(n) { BooleanArray(m) { false } }

    repeat(n) { idx ->
        arr[idx] = readLine().toCharArray()
    }

    println(bfs())
}

private fun bfs(): Int {
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    queue.add(Triple(0, 0, 1))
    visited[0][0] = true

    while (queue.isNotEmpty()) {
        val (a, b, c) = queue.poll()

        if (a == N - 1 && b == M - 1) {
            return c
        }

        for (i in 0 until 4) {
            val nr = a + dr[i]
            val nc = b + dc[i]

            if (nr in 0 until N && nc in 0 until M && !visited[nr][nc] && arr[nr][nc] == '1') {
                queue.add(Triple(nr, nc, c + 1))
                visited[nr][nc] = true
            }
        }
    }

    return -1
}

package october.october07

import java.util.*

private fun main() {
    val r = System.`in`.bufferedReader()
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()

    val (n, m) = r.readLine().split(' ').map { it.toInt() }
    val arr = Array(m) { IntArray(n) }

    for (y in 0 until m) with(StringTokenizer(r.readLine())) {
        for (x in 0 until n) {
            val num = nextToken().toInt()
            if (num == 1) queue += Triple(x, y, 0)
            arr[y][x] = num - 1
        }
    }

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    while (queue.isNotEmpty()) {
        val (x, y, t) = queue.poll()

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx !in 0 until n || ny !in 0 until m) continue
            if (arr[ny][nx] != -1) continue

            arr[ny][nx] = t + 1
            queue += Triple(nx, ny, t + 1)
        }
    }

    var t = 0

    for (row in arr) {
        for (col in row) {
            if (col == -1) t = -1
            if (t != -1 && col > t) t = col
        }
    }

    println(t)
}
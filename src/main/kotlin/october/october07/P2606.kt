package october.october07

import java.util.*

private fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val map = Array(a + 1) { IntArray(a + 1) { 0 } }
    val visited = BooleanArray(a + 1)
    var ans = 0

    repeat(b) {
        val (c, d) = readLine()!!.split(" ").map { it.toInt() }
        map[c][d] = 1
        map[d][c] = 1
    }

    fun bfs() {
        val queue = LinkedList<Int>()
        queue.add(1)
        visited[1] = true
        ans++

        while (queue.isNotEmpty()) {
            val now = queue.poll()

            for (i in 1..a) {
                if (map[now][i] == 1 && !visited[i]) {
                    queue.add(i)
                    visited[i] = true
                    ans++
                }
            }
        }
    }

    bfs()
    println(ans - 1)
}
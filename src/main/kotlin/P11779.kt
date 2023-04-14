import java.util.*

private fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val info = Array(m) { readLine().split(' ').map { it.toInt() } }

    val (start, end) = readLine().split(' ').map { it.toInt() }

    val map = Array(n + 1) { IntArray(n + 1) { -1 } }
    val paths = IntArray(n + 1) { -1 }

    for (line in info) {
        if (map[line[0]][line[1]] == -1 || map[line[0]][line[1]] > line[2])
            map[line[0]][line[1]] = line[2]
    }

    fun dijkstra(): IntArray {
        val distances = IntArray(n + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Vertex> { v1, v2 -> v1.cost - v2.cost }
        distances[start] = 0
        paths[start] = 0
        pq.offer(Vertex(start, 0))

        while (pq.isNotEmpty()) {
            val now = pq.poll()
            if (distances[now.v] < now.cost)
                continue
            for (j in 1 until map[now.v].size) {
                if (map[now.v][j] != -1) {
                    val cost = now.cost + map[now.v][j]
                    if (distances[j] > cost) {
                        distances[j] = cost
                        paths[j] = now.v
                        pq.offer(Vertex(j, cost))
                    }
                }
            }
        }
        return distances
    }

    val result = dijkstra()
    println(result[end])

    val path = mutableListOf<Int>()
    val answer = StringBuilder()
    var cur = end
    while (cur != 0) {
        path.add(cur)
        cur = paths[cur]
    }
    println(path.size)
    for (i in path.size - 1 downTo 0) {
        answer.append("${path[i]} ")
    }
    print(answer.toString())
}

private data class Vertex(val v: Int, val cost: Int)
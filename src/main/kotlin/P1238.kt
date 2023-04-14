import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.max

private const val INF = 10000000

private data class Node4(
    val end: Int,
    val dist: Int
) : Comparable<Node4> {
    override fun compareTo(other: Node4): Int {
        return dist - other.dist
    }
}

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m, x) = readLine().split(" ").map { it.toInt() }
    val map = ArrayList<ArrayList<Node4>>()
    for (i in 0..n) {
        map.add(ArrayList())
    }

    repeat(m) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        map[a].add(Node4(b, c))
    }

    fun dijkstra(start: Int, end: Int): Int {
        val dist = IntArray(n + 1) { INF }
        val pq = PriorityQueue<Node4>()

        dist[start] = 0
        pq.add(Node4(start, 0))

        while (pq.isNotEmpty()) {
            val now = pq.poll()

            if (dist[now.end] < now.dist) {
                continue
            }

            for (nextNode in map[now.end]) {
                val nextIndex = nextNode.end
                val nextDist = now.dist + nextNode.dist

                if (nextDist < dist[nextIndex]) {
                    dist[nextIndex] = nextDist
                    pq.add(Node4(nextIndex, nextDist))
                }
            }
        }

        return dist[end]
    }

    var max = 0
    for (i in 1..n) {
        var sum = 0
        sum += dijkstra(i, x)
        sum += dijkstra(x, i)
        max = max(max, sum)
    }

    println(max)
}

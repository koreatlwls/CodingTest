import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private const val INF = 10000000

private data class Node2(
    val index: Int,
    val dist: Int
) : Comparable<Node2> {
    override fun compareTo(other: Node2): Int {
        return dist - other.dist
    }
}

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()

    val (v, e) = readLine().split(" ").map { it.toInt() }
    val k = readLine().toInt()

    val dist = Array(v + 1) { INF }
    val adj = ArrayList<ArrayList<Node2>>()
    for (i in 0..v) {
        adj.add(ArrayList())
    }

    repeat(e) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }

        adj[a].add(Node2(b, c))
    }

    val queue = PriorityQueue<Node2>()
    dist[k] = 0
    queue.add(Node2(k, 0))

    while (queue.isNotEmpty()) {
        val now = queue.poll()

        if (dist[now.index] < now.dist) continue

        for (nextNode in adj[now.index]) {
            val nextIndex = nextNode.index
            val nextDist = now.dist + nextNode.dist
            if (nextDist < dist[nextIndex]) {
                dist[nextIndex] = nextDist
                queue.add(Node2(nextIndex, nextDist))
            }
        }
    }

    for (i in 1..v) {
        if (dist[i] == INF) sb.append("INF\n")
        else sb.append("${dist[i]}\n")
    }

    println(sb)
}


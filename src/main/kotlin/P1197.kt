import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    data class Edge(
        val start: Int,
        val end: Int,
        val weight: Int
    ) : Comparable<Edge> {
        override fun compareTo(other: Edge): Int {
            return weight - other.weight
        }
    }

    val (v, e) = readLine().split(" ").map { it.toInt() }
    val queue = PriorityQueue<Edge>()
    val parent = IntArray(v + 1)
    for (i in 1..v) {
        parent[i] = i
    }

    repeat(e) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        queue.add(Edge(a, b, c))
    }

    fun find(n: Int): Int {
        if (parent[n] == n) {
            return n
        }
        parent[n] = find(parent[n])
        return parent[n]
    }

    fun union(n1: Int, n2: Int) {
        val p1 = find(n1)
        val p2 = find(n2)

        if (p1 < p2)
            parent[p2] = p1
        else
            parent[p1] = p2
    }

    var weight = 0
    while (queue.isNotEmpty()) {
        val now = queue.poll()

        if (find(now.start) != find(now.end)) {
            union(now.start, now.end)
            weight += now.weight
        }
    }

    println(weight)
}


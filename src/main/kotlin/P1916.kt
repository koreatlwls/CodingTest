import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

private var n = 0
private var m = 0
private lateinit var graph: Array<MutableList<Node>>
private lateinit var dist: IntArray
private const val INF = Integer.MAX_VALUE

//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    n = readLine().toInt()
//    m = readLine().toInt()
//
//    graph = Array(n + 1) { mutableListOf() }
//    dist = IntArray(n + 1) { INF }
//
//    repeat(m) {
//        val (a, b, c) = readLine().split(" ").map { it.toInt() }
//
//        graph[a].add(Node(b, c))
//    }
//
//    val (start, end) = readLine().split(" ").map { it.toInt() }
//    println(dijkstra(start, end))
//}

private fun dijkstra(start: Int, end: Int): Int {
    val pq = PriorityQueue<Node>()
    val visited = BooleanArray(n + 1)

    dist[start] = 0
    pq.add(Node(start, 0))

    while (pq.isNotEmpty()) {
        val now = pq.poll()

        if (!visited[now.end]) {
            visited[now.end] = true

            graph[now.end].forEach {
                if (!visited[it.end] && dist[it.end] > dist[now.end] + it.cost) {
                    dist[it.end] = dist[now.end] + it.cost
                    pq.add(Node(it.end, dist[it.end]))
                }
            }
        }
    }

    return dist[end]
}

private data class Node(
    val end: Int,
    val cost: Int
) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return cost - other.cost
    }
}

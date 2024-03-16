package dijkstra

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

private lateinit var dist: IntArray
private lateinit var arr: ArrayList<ArrayList<Node>>
private lateinit var visited: BooleanArray
private val queue = PriorityQueue<Node>()
private const val INF = Int.MAX_VALUE

private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val strSplit = br.readLine().split(" ")
    val n = strSplit[0].toInt()
    val m = strSplit[1].toInt()
    val k = strSplit[2].toInt()
    val x = strSplit[3].toInt()

    dist = IntArray(n) { INF }
    visited = BooleanArray(n)
    arr = ArrayList()

    for (i in 0 until n) {
        arr.add(ArrayList())
    }

    repeat(m) {
        val split = br.readLine().split(" ")
        val start = split[0].toInt() - 1
        val end = split[1].toInt() - 1

        arr[start].add(Node(end, 1))
    }

    dijkstra(x - 1)

    var find = false
    for (i in dist.indices) {
        if (dist[i] == k) {
            find = true
            println(i + 1)
        }
    }

    if (!find) println(-1)
}

private fun dijkstra(start: Int) {
    dist[start] = 0
    queue.add(Node(start, 0))

    while (queue.isNotEmpty()) {
        val now = queue.poll()

        if (dist[now.idx] < now.dist) continue

        for (i in 0 until arr[now.idx].size) {
            val nextIdx = arr[now.idx][i].idx
            val nextDist = now.dist + arr[now.idx][i].dist

            if (nextDist < dist[nextIdx]) {
                dist[nextIdx] = nextDist
                queue.add(Node(nextIdx, nextDist))
            }
        }
    }
}

private data class Node(
    val idx: Int,
    val dist: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.dist - other.dist
    }
}
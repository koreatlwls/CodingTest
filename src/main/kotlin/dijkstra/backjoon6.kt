package dijkstra

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val visited = Array(100001) { false }
    queue.add(Pair(n, 0))
    visited[n] = true
    var result = 0

    while (queue.isNotEmpty()) {
        val (dest, count) = queue.poll()
        if (dest == k) {
            result = count
            break
        }

        traverse(queue, visited, dest + 1, count)
        traverse(queue, visited, dest - 1, count)
        traverse(queue, visited, dest * 2, count)
    }

    println(result)
}

private fun traverse(
    queue: Queue<Pair<Int, Int>>,
    visited: Array<Boolean>,
    nDest: Int,
    count: Int
) {
    if (nDest in 0 until 100001 && !visited[nDest]) {
        queue.add(Pair(nDest, count + 1))
        visited[nDest] = true
    }
}
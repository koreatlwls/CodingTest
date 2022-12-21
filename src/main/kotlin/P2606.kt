import java.io.BufferedReader
import java.io.InputStreamReader

//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val n = readLine().toInt()
//    val m = readLine().toInt()
//
//    val graph = Array(n + 1) { mutableListOf<Int>() }
//
//    repeat(m) {
//        val (a, b) = readLine().split(" ").map { it.toInt() }
//
//        graph[a].add(b)
//        graph[b].add(a)
//    }
//
//    println(bfs(graph, n))
//}

private fun bfs(graph: Array<MutableList<Int>>, n: Int): Int {
    graph.forEach {
        it.sort()
    }

    var cnt = 0

    val visited = Array(n + 1) { false }
    val queue = mutableListOf<Int>()

    visited[1] = true
    queue.add(1)

    while (queue.isNotEmpty()) {
        val top = queue.removeLast()
        graph[top].forEach {
            if(!visited[it]){
                queue.add(it)
                visited[it] = true
                cnt++
            }
        }
    }

    return cnt
}

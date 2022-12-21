import java.io.BufferedReader
import java.io.InputStreamReader

private val sb = StringBuilder()

//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val (n, m, v) = readLine().split(" ").map { it.toInt() }
//    val graph = Array(n + 1) { mutableListOf<Int>() }
//    repeat(m) {
//        val (a, b) = readLine().split(" ").map { it.toInt() }
//        graph[a].add(b)
//        graph[b].add(a)
//    }
//
//    dfs(graph, v, n)
//    bfs(graph, v, n)
//    println(sb)
//}

private fun dfs(graph: Array<MutableList<Int>>, start: Int, n: Int) {
    graph.forEach {
        it.sortDescending()
    }

    val visited = Array(n + 1) { false }
    val stack = mutableListOf<Int>()

    stack.add(start)
    visited[start] = true
    sb.append("$start ")

    while (stack.isNotEmpty()) {
        val top = stack.removeLast()
        if (!visited[top]) {
            sb.append("$top ")
            visited[top] = true
        }

        graph[top].forEach {
            if (!visited[it]) {
                stack.add(it)
            }
        }
    }

    sb.append("\n")
}

private fun bfs(graph: Array<MutableList<Int>>, start: Int, n: Int) {
    graph.forEach {
        it.sort()
    }

    val visited = Array(n + 1) { false }
    val queue = mutableListOf<Int>()

    queue.add(start)
    visited[start] = true
    sb.append("$start ")

    while (queue.isNotEmpty()) {
        val top = queue.removeFirst()
        graph[top].forEach {
            if (!visited[it]) {
                queue.add(it)
                sb.append("$it ")
                visited[it] = true
            }
        }
    }

    sb.append("\n")
}



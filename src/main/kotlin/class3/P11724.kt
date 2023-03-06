package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var graph: Array<ArrayList<Int>>
private lateinit var visited: BooleanArray
private var answer = 0

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { ArrayList<Int>() }
    visited = BooleanArray(n + 1)


    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }

        graph[a].add(b)
        graph[b].add(a)
    }

    for (i in 1..n) {
        if (!visited[i]) {
            dfs(i)
            answer++
        }
    }

    println(answer)
}

private fun dfs(now: Int) {
    visited[now] = true
    for (i in graph[now]) {
        if (!visited[i]) {
            dfs(i)
        }
    }
}

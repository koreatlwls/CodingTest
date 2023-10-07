package october.october07

import java.util.*

private val visited = Array(1001) { false }
private val edges = Array<MutableList<Int>>(1001) { mutableListOf() }

private fun dfs(v: Int) {
    if (visited[v]) return
    visited[v] = true

    print("$v ")
    edges[v].forEach { dfs(it) }
}

private fun bfs(v: Int) {
    val q: Queue<Int> = LinkedList()
    q.add(v)

    while (!q.isEmpty()) {
        val p = q.poll()
        if (visited[p]) continue
        visited[p] = true

        print("$p ")
        edges[p].forEach { q.add(it) }
    }
}

private fun main() {
    val (n, m, v) = readLine()!!.split(" ").map { it.toInt() }

    repeat(m) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        edges[a].add(b)
        edges[b].add(a)
    }

    edges.forEach { it.sort() }
    dfs(v)
    println()
    visited.fill(false)
    bfs(v)
}
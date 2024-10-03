import java.util.*

private fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val tree = Array(n + 1) { mutableListOf<Int>() }
    val parent = IntArray(n + 1)

    repeat(n - 1) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        tree[a].add(b)
        tree[b].add(a)
    }

    bfs(tree, parent, n)

    for (i in 2..n) {
        println(parent[i])
    }
}

private fun bfs(tree: Array<MutableList<Int>>, parent: IntArray, n: Int) {
    val visited = BooleanArray(n + 1)
    val queue = LinkedList<Int>()
    queue.add(1)
    visited[1] = true

    while (queue.isNotEmpty()) {
        val node = queue.poll()

        for (i in tree[node]) {
            if (!visited[i]) {
                parent[i] = node
                visited[i] = true
                queue.add(i)
            }
        }
    }
}
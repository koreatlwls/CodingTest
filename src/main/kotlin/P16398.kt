import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

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

    val n = readLine().toInt()
    val list = mutableListOf<Edge>()
    val parent = IntArray(n + 1)

    for (i in 1..n) {
        val st = StringTokenizer(readLine())
        for (j in 1..n) {
            val cost = st.nextToken().toInt()
            if (cost != 0) {
                list.add(Edge(i, j, cost))
            }
        }
    }
    list.sort()

    for (i in 1..n) {
        parent[i] = i
    }

    fun find(n: Int): Int {
        if (parent[n] == n) {
            return n
        }
        parent[n] = find(parent[n])
        return parent[n]
    }

    fun union(a: Int, b: Int) {
        val p1 = find(a)
        val p2 = find(b)

        if (p1 < p2)
            parent[p2] = p1
        else
            parent[p1] = p2
    }

    var answer = 0L
    for (i in list.indices) {
        val now = list[i]

        if (find(now.start) != find(now.end)) {
            union(now.start, now.end)
            answer += now.weight
        }
    }

    println(answer)
}

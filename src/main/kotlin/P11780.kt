import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val INF = 1000001
    val sb = StringBuilder()

    val dist = Array(n + 1) { IntArray(n + 1) }
    val next = Array(n + 1) { IntArray(n + 1) }

    for (i in 1..n) {
        for (j in 1..n) {
            next[i][j] = -1
            if (i == j) continue
            dist[i][j] = INF
        }
    }

    repeat(m) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }

        dist[a][b] = min(dist[a][b], c)
        next[a][b] = a
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                    next[i][j] = next[k][j]
                }
            }
        }
    }

    for (i in 1..n) {
        for (j in 1..n) {
            if (dist[i][j] >= INF) {
                sb.append("0 ")
            } else {
                sb.append("${dist[i][j]} ")
            }
        }
        sb.append("\n")
    }

    for (i in 1..n) {
        for (j in 1..n) {
            if (next[i][j] == -1) {
                sb.append("0\n")
            } else {
                val path = Stack<Int>()
                var pre = j
                path.add(j)

                while (i != next[i][pre]) {
                    pre = next[i][pre]
                    path.add(pre)
                }

                sb.append("${path.size + 1} ")
                sb.append("$i ")
                while (path.isNotEmpty()) {
                    sb.append("${path.pop()} ")
                }
                sb.append("\n")
            }
        }
    }

    println(sb)
}

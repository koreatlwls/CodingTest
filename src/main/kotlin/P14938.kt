import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val MAX = 10000000
    val (n, m, r) = readLine().split(" ").map { it.toInt() }

    val dist = IntArray(n + 1)
    val map = Array(n + 1) { IntArray(n + 1) { MAX } }

    val st = StringTokenizer(readLine())
    repeat(n) { idx ->
        dist[idx + 1] = st.nextToken().toInt()
    }
    repeat(n) { idx ->
        map[idx + 1][idx + 1] = 0
    }

    repeat(r) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }

        map[a][b] = c
        map[b][a] = c
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (map[i][j] > map[i][k] + map[k][j]) {
                    map[i][j] = map[i][k] + map[k][j]
                }
            }
        }
    }

    var max = 0

    for (i in 1..n) {
        var sum = 0
        for (j in 1..n) {
            if (map[i][j] <= m) {
                sum += dist[j]
            }
        }

        max = max(max, sum)
    }

    println(max)
}

package dijkstra

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n + 1) { IntArray(n + 1) { 987654321 } }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        map[a][b] = 1
        map[b][a] = 1
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (i == j) {
                    map[i][j] = 0
                    continue
                }

                if (map[i][j] > map[i][k] + map[k][j]) {
                    map[i][j] = map[i][k] + map[k][j]
                }
            }
        }
    }

    var answer = 987654321
    var kevin = 987654321

    for (i in 1..n) {
        var sum = 0
        for (j in 1..n) {
            sum+= map[i][j]
        }

        if(kevin > sum){
            kevin = sum
            answer = i
        }
    }

    println(answer)
}
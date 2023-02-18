package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n + 1) { IntArray(n + 1) { 987654321 } }

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        arr[a][b] = 1
        arr[b][a] = 1
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (i == j) {
                    arr[i][j] = 0
                    continue
                }
                arr[i][j] = min(arr[i][k] + arr[k][j], arr[i][j])
            }
        }
    }

    var sum = 987654321
    var answer = 0

    for (i in 1..n) {
        var cnt = 0
        for (j in 1..n) {
            if (i == j) continue
            cnt += arr[i][j]
        }

        if (sum > cnt) {
            sum = cnt
            answer = i
        }
    }

    println(answer)
}

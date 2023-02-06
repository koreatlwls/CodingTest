package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val (M, N) = readLine().split(" ").map { it.toInt() }

    val prime = BooleanArray(N + 1)
    for (i in 2..N) {
        if (prime[i]) continue
        if (i >= M) sb.append(i).append("\n")

        var j = i + i
        while (j <= N) {
            prime[j] = true
            j += i
        }
    }

    println(sb)
}

package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min
import kotlin.math.sqrt

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val dp = IntArray(n + 1)

    for (i in 1..n) {
        dp[i] = 4
        var j = sqrt(i.toDouble()).toInt()
        while (j != 0) {
            dp[i] = min(dp[i], dp[i - j * j] + 1)
            j -= 1
        }
    }

    println(dp[n])
}

package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val dp = IntArray(n + 1) { 0 }
    dp[1] = 0

    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1
        if (i % 2 == 0) dp[i] = min(dp[i], dp[i / 2] + 1)
        if (i % 3 == 0) dp[i] = min(dp[i], dp[i / 3] + 1)
    }

    println(dp[n])
}

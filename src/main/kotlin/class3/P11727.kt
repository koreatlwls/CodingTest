package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val dp = IntArray(1001)
    dp[1] = 1
    dp[2] = 3

    for (i in 3..1000) {
        dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007
    }

    println(dp[readLine().toInt()])
}

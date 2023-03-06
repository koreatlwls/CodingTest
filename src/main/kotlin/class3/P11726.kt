package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val dp = IntArray(1001)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2

    for (i in 3 until dp.size) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
    }

    println(dp[readLine().toInt()])
}

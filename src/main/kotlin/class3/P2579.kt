package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = Array(n + 1) { 0 }
    val dp = Array(n + 1) { 0 }

    for (i in 1 until arr.size) {
        arr[i] = readLine().toInt()
    }

    for (i in 1 until dp.size) {
        when (i) {
            1 -> dp[i] = arr[1]
            2 -> dp[i] = arr[1] + arr[2]
            else -> dp[i] = max((arr[i] + dp[i - 2]), (arr[i] + arr[i - 1] + dp[i - 3]))
        }
    }

    println(dp[n])
}

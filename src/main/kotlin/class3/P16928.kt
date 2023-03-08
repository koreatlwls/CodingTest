package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private val map = IntArray(101)
private val visited = IntArray(101) { Int.MAX_VALUE }

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    fun read() = readLine()!!.split(" ").map { it.toInt() }
    val (n, m) = read()

    val board = Array(101) { it }
    repeat(n + m) {
        val (s, e) = read()
        board[s] = e
    }

    var dp = Array(101) { 0 }
    dp[1] = 1

    var cnt = 0

    while (dp[100] == 0) {
        cnt++

        val next = Array(101) { 0 }

        for ((i, n) in dp.withIndex()) {
            if (n > 0) {
                for (j in 1..6) {
                    if (i + j <= 100) {
                        next[board[i + j]] = 1
                    }
                }
            }
        }

        dp = next
    }

    println(cnt)
}



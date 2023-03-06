package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    val pSum = IntArray(n + 1)

    repeat(n) { idx ->
        pSum[idx + 1] = pSum[idx] + arr[idx]
    }

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }

        sb.append(pSum[b] - pSum[a - 1]).append("\n")
    }

    println(sb)
}

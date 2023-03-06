package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = Array(n) { IntArray(n) }

    repeat(n) { idx ->
        arr[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] = 1
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            print("${arr[i][j]} ")
        }
        println()
    }
}

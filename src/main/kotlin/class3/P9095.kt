package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()

    val arr = IntArray(12)
    arr[1] = 1
    arr[2] = 2
    arr[3] = 4

    for (i in 4..11) {
        arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3]
    }

    repeat(readLine().toInt()) {
        val input = readLine().toInt()

        sb.append(arr[input]).append("\n")
    }

    println(sb)
}

package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = HashMap<String, String>()

    repeat(n) {
        val input = readLine().split(" ")
        map[input[0]] = input[1]
    }

    repeat(m) {
        val input = readLine()
        sb.append(map[input]).append("\n")
    }

    println(sb)
}

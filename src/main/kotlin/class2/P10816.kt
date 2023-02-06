package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cards = IntArray(20000002){0}
    val sb  = StringBuilder()

    val n = readLine().toInt()
    readLine().split(" ").forEach {
        cards[it.toInt() + 10000000] += 1
    }
    val m = readLine().toInt()
    readLine().split(" ").forEach {
        sb.append("${cards[it.toInt() + 10000000]} ")
    }

    println(sb)
}

package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()

    val strings = Array(n) { readLine() }.distinct().sorted().sortedWith(compareBy { it.length })
    for (s in strings) {
        println(s)
    }
}

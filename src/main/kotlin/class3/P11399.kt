package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }

    var sum = 0
    var pSum = 0
    list.sorted().forEach {
        pSum += it
        sum +=pSum
    }

    println(sum)
}

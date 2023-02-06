package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()

    val nString = N.toString().length

    for (i in N - (9 * nString) until N) {
        val iString = i.toString().toCharArray()

        var sum = 0
        iString.forEach {
            sum += it - '0'
        }

        val result = i + sum
        if (result == N) {
            println(i)
            return
        }
    }
    println(0)
}

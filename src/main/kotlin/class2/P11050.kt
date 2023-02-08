package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (a,b) = readLine().split(" ").map { it.toInt() }
    print(loop(a) / (loop(b) * loop(a-b)))
}

private fun loop(x: Int): Int {
    var r = 1;
    for (i in x downTo 1) r *= i
    return r
}


package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (A, B, V) = readLine().split(" ").map { it.toInt() }

    val result = if ((V - A) % (A - B) == 0) (V - A) / (A - B) + 1 else (V - A) / (A - B) + 2
    println(result)
}

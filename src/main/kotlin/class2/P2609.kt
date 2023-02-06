package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (first, second) = readLine().split(" ").map { it.toInt() }

    val number = gcd(first, second)
    println(number)
    println(first * second / number)
}

private fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a


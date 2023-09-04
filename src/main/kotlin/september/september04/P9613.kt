package september.september04

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)

    repeat(readLine()!!.toInt()) {
        val a = readLine()!!.split(" ").map { it.toLong() }
        println((1 until a.size).map { i -> (1 until i).map { j -> gcd(a[i], a[j]) }.sum() }.sum())
    }
}


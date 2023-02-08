package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private const val M = 1234567891
private const val r = 31

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val input = readLine()

    var pow = 1L
    var answer = 0L

    for(i in 0 until n){
        answer += (input[i] - 'a' + 1) * pow
        pow = (pow * r) % M
    }
    println(answer % M)
}


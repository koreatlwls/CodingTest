package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split("-")
    var min = input[0].split("+").sumOf { it.toInt() }

    for(i in 1 until input.size){
        min -= input[i].split("+").sumOf { it.toInt() }
    }

    println(min)
}

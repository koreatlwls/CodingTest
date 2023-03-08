package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()

    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val sortedArr = arr.distinct().sorted()
    for (i in 0 until n) {
        bw.write("${sortedArr.binarySearch(arr[i])} ")
    }
    bw.close()
}

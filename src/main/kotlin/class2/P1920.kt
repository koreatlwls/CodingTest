package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val N = readLine().toInt()
    val nList = readLine().split(" ").map { it.toInt() }.sorted()
    val M = readLine().toInt()
    val mList = readLine().split(" ").map { it.toInt() }

    mList.forEach {
        sb.append(binSearch(nList, it)).append("\n")
    }

    println(sb)
}

private fun binSearch(list: List<Int>, target: Int): Int {
    var low = 0
    var high = list.size - 1
    var mid = 0

    while (low <= high) {
        mid = (low + high) / 2
        when {
            list[mid] == target -> return 1
            list[mid] > target -> high = mid - 1
            list[mid] < target -> low = mid + 1
        }
    }

    return 0
}
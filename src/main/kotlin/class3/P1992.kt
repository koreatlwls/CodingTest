package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private var N = 0
private lateinit var arr: Array<CharArray>
private val sb = StringBuilder()

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    N = readLine().toInt()
    arr = Array(N) { CharArray(N) }

    repeat(N) { idx ->
        arr[idx] = readLine().toCharArray()
    }

    solution(0, 0, N)
    println(sb)
}

private fun solution(row: Int, col: Int, size: Int) {
    if (check(row, col, size)) {
        sb.append(arr[row][col])
        return
    } else {
        val newSize = size / 2
        sb.append("(")

        solution(row, col, newSize)
        solution(row, col + newSize, newSize)
        solution(row + newSize, col, newSize)
        solution(row + newSize, col + newSize, newSize)
        sb.append(")")
    }
}

private fun check(row: Int, col: Int, size: Int): Boolean {
    val value = arr[row][col]

    for (i in row until row + size) {
        for (j in col until col + size) {
            if (value != arr[i][j]) return false
        }
    }

    return true
}

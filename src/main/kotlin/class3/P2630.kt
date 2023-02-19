package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var arr: Array<IntArray>
private var zeroCount = 0
private var oneCount = 0

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    arr = Array(n) { IntArray(n) }

    repeat(n) { idx ->
        arr[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    solution(0, 0, n)

    println(zeroCount)
    println(oneCount)
}

private fun solution(row: Int, col: Int, size: Int) {
    if (check(row, col, size)) {
        val value = arr[row][col]
        if (value == 1) {
            oneCount++
        } else {
            zeroCount++
        }
    } else {
        val newSize = size / 2

        solution(row, col, newSize)
        solution(row, col + newSize, newSize)
        solution(row + newSize, col, newSize)
        solution(row + newSize, col + newSize, newSize)
    }
}

private fun check(row: Int, col: Int, size: Int): Boolean {
    val value = arr[row][col]
    for (i in row until row + size) {
        for (j in col until col + size) {
            if (value != arr[i][j]) {
                return false
            }
        }
    }

    return true
}

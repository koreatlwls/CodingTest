package nadongbin.implementation

// 상하좌우

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    // 상 하 좌 우
    val dr = arrayOf(-1, 1, 0, 0)
    val dc = arrayOf(0, 0, -1, 1)

    val plans = readLine().split(" ")

    var startRow = 1
    var startCol = 1
    plans.forEach {
        var nextRow = startRow
        var nextCol = startCol

        when (it) {
            "R" -> {
                nextRow += dr[3]
                nextCol += dc[3]
            }
            "L" -> {
                nextRow += dr[2]
                nextCol += dc[2]
            }
            "U" -> {
                nextRow += dr[0]
                nextCol += dc[0]
            }
            else -> {
                nextRow += dr[1]
                nextCol += dc[1]
            }
        }

        if (nextRow in 1..n && nextCol in 1..n) {
            startRow = nextRow
            startCol = nextCol
        }
    }

    println("$startRow $startCol")
}

package nadongbin.implementation

// 왕실의 나이트

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val map = mapOf('a' to 1, 'b' to 2, 'c' to 3, 'd' to 4, 'e' to 5, 'f' to 6, 'g' to 7, 'h' to 8)

    val input = readLine()

    val dr = arrayOf(-2, 2, -1, 1, -2, 2, -1, 1)
    val dc = arrayOf(-1, 1, -2, 2, 1, -1, 2, -2)

    val startRow = map[input[0]]!!
    val startCol = input[1] - '0'

    var answer = 0
    for (i in 0 until 8) {
        val nextRow = startRow + dr[i]
        val nextCol = startCol + dc[i]

        if (nextRow in 1..8 && nextCol in 1..8) {
            answer++
        }
    }

    println(answer)
}

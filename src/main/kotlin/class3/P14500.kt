package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

private var MAX_NUMBER = Integer.MIN_VALUE
private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private var n = 0
private var m = 0
private val dx = arrayOf(-1, 1, 0, 0)
private val dy = arrayOf(0, 0, -1, 1)

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine(), " ")
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    arr = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }

    repeat(n) { idx ->
        arr[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            visited[i][j] = true
            solve(i, j, arr[i][j], 1)
            visited[i][j] = false
        }
    }

    println(MAX_NUMBER)
}

private fun solve(row: Int, col: Int, sum: Int, count: Int) {
    if (count == 4) {
        MAX_NUMBER = max(MAX_NUMBER, sum)
        return
    }

    for (i in 0 until 4) {
        val curRow = row + dx[i]
        val curCol = col + dy[i]

        if (curRow in 0 until n && curCol in 0 until m) {
            if (visited[curRow][curCol].not()) {
                if (count == 2) {
                    visited[curRow][curCol] = true
                    solve(row, col, sum + arr[curRow][curCol], count + 1)
                    visited[curRow][curCol] = false
                }

                visited[curRow][curCol] = true
                solve(curRow, curCol, sum + arr[curRow][curCol], count + 1)
                visited[curRow][curCol] = false
            }
        }
    }
}

package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private var m = 0
private var n = 0
private var k = 0

private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, -1, 1)

private lateinit var arr: Array<Array<Int>>

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine(), " ")
        m = st.nextToken().toInt()
        n = st.nextToken().toInt()
        k = st.nextToken().toInt()

        arr = Array(m) { Array(n) { 0 } }

        repeat(k) {
            val (a, b) = readLine().split(" ").map { it.toInt() }
            arr[a][b] = 1
        }

        var count = 0
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0
                    find(i, j)
                    count++
                }
            }
        }

        sb.append(count).append("\n")
    }

    println(sb)
}

private fun find(x: Int, y: Int) {
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
            if (arr[nx][ny] == 1) {
                arr[nx][ny] = 0
                find(nx, ny)
            }
        }
    }
}
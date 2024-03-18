package programmers

import kotlin.math.abs

class Solution41 {

    val route = StringBuilder()
    val dr = arrayOf(1, 0, 0, -1)
    val dc = arrayOf(0, -1, 1, 0)
    val dir = arrayOf("d", "l", "r", "u")
    var endRow = 0
    var endCol = 0
    var N = 0
    var M = 0
    var answer: String? = null

    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        N = n
        M = m
        endRow = r
        endCol = c

        val length = getDistance(x, y, r, c)
        if ((k - length) % 2 == 1 || k < length) return "impossible"
        dfs(x, y, 0, k)
        return answer ?: "impossible"
    }

    fun dfs(row: Int, col: Int, cnt: Int, k: Int) {
        if (answer != null) return
        if (cnt + getDistance(row, col, endRow, endCol) > k) return
        if (cnt == k) {
            answer = route.toString()
            return
        }

        for (i in 0 until 4) {
            val nextRow = row + dr[i]
            val nextCol = col + dc[i]

            if (nextRow in 1..N && nextCol in 1..M) {
                route.append(dir[i])
                dfs(nextRow, nextCol, cnt + 1, k)
                route.delete(cnt, cnt + 1)
            }
        }
    }

    fun getDistance(row: Int, col: Int, goalRow: Int, goalCol: Int): Int {
        return abs(row - goalRow) + abs(col - goalCol)
    }
}
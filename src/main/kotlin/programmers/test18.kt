package programmers

import java.util.*

// 리코쳇 로봇

private val dr = arrayOf(-1, 1, 0, 0)
private val dc = arrayOf(0, 0, -1, 1)
private lateinit var map: Array<String>

private fun solution(board: Array<String>): Int {
    map = board

    var startRow = 0
    var startCol = 0

    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == 'R') {
                startRow = i
                startCol = j
            }
        }
    }

    return bfs(startRow, startCol)
}

private fun bfs(row: Int, col: Int): Int {
    val visited = Array(map.size) { BooleanArray(map[0].length) }
    visited[row][col] = true
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    queue.add(Triple(row, col, 0))

    while (queue.isNotEmpty()) {
        val now = queue.poll()
        val nowRow = now.first
        val nowCol = now.second
        val nowCount = now.third

        if (map[nowRow][nowCol] == 'G') {
            return nowCount
        }

        for (i in 0 until 4) {
            var nextRow = nowRow
            var nextCol = nowCol

            while (true) {
                nextRow += dr[i]
                nextCol += dc[i]

                if (nextRow !in map.indices || nextCol < 0 || nextCol >= map[0].length || map[nextRow][nextCol] == 'D') {
                    break
                }
            }
            nextRow -= dr[i]
            nextCol -= dc[i]

            if (!visited[nextRow][nextCol]) {
                queue.add(Triple(nextRow, nextCol, nowCount + 1))
                visited[nextRow][nextCol] = true
            }
        }
    }

    return -1
}

package programmers

import java.util.*

// 무인도 여행

private val dr = arrayOf(-1, 1, 0, 0)
private val dc = arrayOf(0, 0, -1, 1)
private lateinit var visited: Array<BooleanArray>

private fun solution(maps: Array<String>): IntArray {
    val answer = mutableListOf<Int>()
    visited = Array(maps.size) { BooleanArray(maps[0].length) }

    for (i in maps.indices) {
        for (j in 0 until maps[0].length) {
            if (maps[i].get(j) != 'X' && visited[i][j].not()) {
                answer.add(bfs(maps, i, j))
            }
        }
    }

    if (answer.isEmpty()) {
        answer.add(-1)
    }
    answer.sort()

    return answer.toIntArray()
}

private fun bfs(maps: Array<String>, row: Int, col: Int): Int {
    var answer = 0
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(row, col))
    visited[row][col] = true

    while (queue.isNotEmpty()) {
        val now = queue.poll()
        answer += Character.getNumericValue(maps[now.first][now.second])

        for (i in 0 until 4) {
            val nextRow = now.first + dr[i]
            val nextCol = now.second + dc[i]

            if (nextRow in maps.indices && nextCol in 0 until maps[0].length && visited[nextRow][nextCol].not() && maps[nextRow][nextCol] != 'X') {
                queue.add(Pair(nextRow, nextCol))
                visited[nextRow][nextCol] = true
            }
        }
    }

    return answer
}

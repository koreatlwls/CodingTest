package programmers

import java.util.*

// 미로 탈출

private val dr = arrayOf(-1, 1, 0, 0)
private val dc = arrayOf(0, 0, -1, 1)

private fun solution(maps: Array<String>): Int {
    var answer: Int = 0

    var startPosition = Position(0, 0)
    var leverPosition = Position(0, 0)
    var endPosition = Position(0, 0)

    for (i in maps.indices) {
        for (j in 0 until maps[i].length) {
            when (maps[i].get(j)) {
                'S' -> startPosition = Position(i, j)
                'L' -> leverPosition = Position(i, j)
                'E' -> endPosition = Position(i, j)
                else -> continue
            }
        }
    }

    var check = true
    val first = bfs(maps, startPosition, leverPosition)
    val second = bfs(maps, leverPosition, endPosition)

    if (first < 0 || second < 0) {
        check = false
    }
    answer += first
    answer += second
    answer = if (check) answer else -1

    return answer
}

private fun bfs(maps: Array<String>, startPosition: Position, endPosition: Position): Int {
    val queue: Queue<Pair<Position, Int>> = LinkedList()
    queue.add(Pair(startPosition, 0))
    val visited = Array(maps.size) { BooleanArray(maps[0].length) }
    visited[startPosition.row][startPosition.col] = true

    while (queue.isNotEmpty()) {
        val now = queue.poll()

        if (now.first == endPosition) {
            return now.second
        }

        for (i in 0 until 4) {
            val nextRow = now.first.row + dr[i]
            val nextCol = now.first.col + dc[i]

            if (
                nextRow in maps.indices &&
                nextCol in 0 until maps[0].length &&
                visited[nextRow][nextCol].not() &&
                maps[nextRow][nextCol] != 'X'
            ) {
                queue.add(Pair(Position(nextRow, nextCol), now.second + 1))
                visited[nextRow][nextCol] = true
            }
        }
    }

    return -1
}


private data class Position(
    val row: Int,
    val col: Int,
)
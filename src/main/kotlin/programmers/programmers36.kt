package programmers

class Solution36 {

    lateinit var visited: Array<BooleanArray>

    val dr = arrayOf(-1, 1, 0, 0)
    val dc = arrayOf(0, 0, -1, 1)

    data class Position(
        val row: Int,
        val col: Int,
    )

    fun solution(maps: Array<String>): IntArray {
        var answer = mutableListOf<Int>()

        visited = Array(maps.size) { BooleanArray(maps[0].length) }

        var check = false
        for (i in maps.indices) {
            for (j in 0 until maps[0].length) {
                if (maps[i][j] != 'X' && !visited[i][j]) {
                    check = true
                    answer.add(bfs(maps, i, j))
                }
            }
        }

        if (!check) {
            answer.add(-1)
        }
        return answer.sorted().toIntArray()
    }

    fun bfs(maps: Array<String>, startRow: Int, startCol: Int): Int {
        val queue = ArrayDeque<Position>()
        var result = maps[startRow][startCol] - '0'
        queue.add(Position(startRow, startCol))
        visited[startRow][startCol] = true

        while (queue.isNotEmpty()) {
            val now = queue.removeLast()

            for (i in 0 until 4) {
                val nextRow = now.row + dr[i]
                val nextCol = now.col + dc[i]

                if (nextRow in maps.indices && nextCol in 0 until maps[0].length && !visited[nextRow][nextCol] && maps[nextRow][nextCol] != 'X') {
                    queue.add(Position(nextRow, nextCol))
                    visited[nextRow][nextCol] = true
                    result += (maps[nextRow][nextCol] - '0')
                }
            }
        }

        return result
    }
}
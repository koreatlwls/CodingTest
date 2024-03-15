package programmers

import java.util.*

class Solution34 {
    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)

    fun solution(maps: Array<String>): Int {
        var start = Pair(0, 0)
        var exit = Pair(0, 0)
        var lever = Pair(0, 0)

        for (i in maps.indices) {
            for (j in maps[0].indices) {
                if (maps[i][j] == 'S')
                    start = Pair(i, j)
                else if (maps[i][j] == 'E')
                    exit = Pair(i, j)
                else if (maps[i][j] == 'L')
                    lever = Pair(i, j)
            }
        }

        val timeToLever = bfs(start, lever, maps)
        val timeToExit = bfs(lever, exit, maps)

        return if (timeToLever == -1 || timeToExit == -1)
            -1
        else
            timeToLever + timeToExit
    }


    fun bfs(start: Pair<Int, Int>, end: Pair<Int, Int>, map: Array<String>): Int {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val visited = Array(map.size) { IntArray(map[0].length) }

        queue.add(start)
        visited[start.first][start.second] = 1

        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()

            if (x == end.first && y == end.second)
                return visited[end.first][end.second] - 1


            for (i in 0 until 4) {
                val tempX = x + dx[i]
                val tempY = y + dy[i]

                if (tempX in map.indices
                    && tempY in map[0].indices
                    && visited[tempX][tempY] == 0
                    && map[tempX][tempY] != 'X'
                ) {
                    visited[tempX][tempY] = visited[x][y] + 1
                    queue.add(tempX to tempY)
                }
            }
        }

        return -1
    }
}
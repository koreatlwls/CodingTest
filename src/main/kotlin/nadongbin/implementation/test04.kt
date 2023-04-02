package nadongbin.implementation

// 게임 개발

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    var (startRow, startCol, direction) = readLine().split(" ").map { it.toInt() }

    val map = Array(n) { IntArray(m) }
    val visited = Array(n){BooleanArray(m)}

    repeat(n) { idx ->
        map[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val dr = arrayOf(-1, 0, 1, 0)
    val dc = arrayOf(0, 1, 0, -1)

    var answer = 1
    while (true) {
        var count = 0

        for (i in 1..4) {
            count++

            direction -= i
            if (direction < 0) {
                direction += 4
            }

            val nextRow = startRow + dr[direction]
            val nextCol = startCol + dc[direction]

            if(nextRow in 0 until n && nextCol in 0 until m && map[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]){
                startRow = nextRow
                startCol = nextCol
                visited[startRow][startCol] = true
                answer++

                break
            }
        }

        if (count == 4) {
            var nextDirection = direction + 2
            if(nextDirection >=4){
                nextDirection -= 4
            }

            val nextRow = startRow + dr[nextDirection]
            val nextCol = startCol + dc[nextDirection]

            if(nextRow in 0 until n && nextCol in 0 until m && map[nextRow][nextCol] == 0){
                startRow = nextRow
                startCol = nextCol
            }else{
                break
            }
        }
    }

    println(answer)
}

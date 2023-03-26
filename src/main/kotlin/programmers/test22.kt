package programmers

// 공원 산책

private val dr = arrayOf(0, 0, 1, -1)
private val dc = arrayOf(1, -1, 0, 0)

private fun solution(park: Array<String>, routes: Array<String>): IntArray {
    val answer = IntArray(2)

    var startRow = 0
    var startCol = 0

    for (i in park.indices) {
        for (j in 0 until park[i].length) {
            if (park[i][j] == 'S') {
                startRow = i
                startCol = j
            }
        }
    }

    var nextPair = Pair(startRow, startCol)
    routes.forEach {
        val command = it.split(" ")

        val idx = when (command[0]) {
            "E" -> 0
            "W" -> 1
            "S" -> 2
            else -> 3
        }

        nextPair = check(park, idx, command[1].toInt(), nextPair)
    }

    answer[0] = nextPair.first
    answer[1] = nextPair.second
    return answer
}

private fun check(park: Array<String>, idx: Int, count: Int, nowPair: Pair<Int, Int>): Pair<Int, Int> {
    var nextRow = nowPair.first
    var nextCol = nowPair.second
    repeat(count) {
        nextRow += dr[idx]
        nextCol += dc[idx]

        if (nextRow < 0 || nextRow >= park.size || nextCol < 0 || nextCol >= park[0].length || park[nextRow][nextCol] == 'X') {
            return nowPair
        }
    }


    return Pair(nextRow, nextCol)
}

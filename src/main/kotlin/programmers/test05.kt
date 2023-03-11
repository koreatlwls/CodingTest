package programmers

// 혼자서 하는 틱택토

private lateinit var map: Array<CharArray>

private fun win(c: Char): Int {
    var game = 0

    for (i in 0 until 3) {
        if (map[i][0] == c && map[i][1] == c && map[i][2] == c) {
            game++
        }
        if (map[0][i] == c && map[1][i] == c && map[2][i] == c) {
            game++
        }
    }

    if (map[0][0] == c && map[1][1] == c && map[2][2] == c) {
        game++
    }
    if (map[0][2] == c && map[1][1] == c && map[2][0] == c) {
        game++
    }

    return game
}

private fun solution(board: Array<String>): Int {
    var answer = 1
    map = Array(3) { CharArray(3) }
    var oCnt = 0
    var xCnt = 0

    for (i in 0 until 3) {
        for (j in 0 until 3) {
            map[i][j] = board[i].get(j)
            if (map[i][j] == 'O') {
                oCnt++
            }
            if (map[i][j] == 'X') {
                xCnt++
            }
        }
    }

    if (xCnt > oCnt || oCnt - xCnt > 1) {
        return 0
    }
    if (win('O') > 0 && win('X') > 0) {
        return 0
    }
    if (win('O') > 0) {
        if (oCnt == xCnt) {
            return 0
        }
    }
    if (win('X') > 0) {
        if (oCnt > xCnt) {
            return 0
        }
    }

    return answer
}

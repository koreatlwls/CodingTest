package programmers

class Solution33 {
    fun solution(board: Array<String>): Int {
        var cntO = 0
        var cntX = 0
        board.forEach {
            it.forEach { c ->
                if (c == 'O') cntO++
                else if (c == 'X') cntX++
            }
        }
        if (cntX > cntO) return 0
        if (cntO > cntX + 1) return 0

        if (checkWin('O', board) && cntO <= cntX) return 0

        if (checkWin('X', board) && cntO > cntX) return 0

        return 1
    }

    fun checkWin(winner: Char, board: Array<String>): Boolean {
        val w: Boolean = wCheck(winner, board)
        val h: Boolean = hCheck(winner, board)
        val d: Boolean = dCheck(winner, board)
        if (w || h || d) return true
        return false
    }

    fun wCheck(winner: Char, board: Array<String>): Boolean {
        for (i in 0..2) {
            var cnt = 0
            for (j in 0..2) {
                if (board[i][j] == winner) cnt++
            }
            if (cnt == 3) return true
        }
        return false
    }

    fun hCheck(winner: Char, board: Array<String>): Boolean {
        for (j in 0..2) {
            var cnt = 0
            for (i in 0..2) {
                if (board[i][j] == winner) cnt++
            }
            if (cnt == 3) return true
        }
        return false
    }

    fun dCheck(winner: Char, board: Array<String>): Boolean {
        var b1 = true
        var b2 = true
        for (i in 0..2) {
            if (board[i][i] != winner) b1 = false
            if (board[2 - i][i] != winner) b2 = false
        }
        return b1 || b2
    }
}
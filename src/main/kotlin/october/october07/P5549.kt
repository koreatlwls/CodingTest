package october.october07

private fun main() {
    val sb = StringBuilder()
    val (n, m) = readLine()!!.split(" ").map{it.toInt()}
    val k = readLine()!!.toInt()
    val board = (1 .. n).map { readLine()!!.toList() }
    val prefixed = MutableList(n + 1) { MutableList(m + 1) { MutableList(3) { 0 } } }

    for (i in 1 .. n) {
        for (j in 1 .. m) {
            for (l in 0 until 3) prefixed[i][j][l] = prefixed[i - 1][j][l] + prefixed[i][j - 1][l] - prefixed[i - 1][j - 1][l]

            when (board[i - 1][j - 1]) {
                'J' -> prefixed[i][j][0] ++
                'O' -> prefixed[i][j][1] ++
                'I' -> prefixed[i][j][2] ++
            }
        }
    }

    repeat(k) {
        val (x1, y1, x2, y2) = readLine()!!.split(" ").map{it.toInt()}
        sb.append("${prefixed[x2][y2][0] - prefixed[x1 - 1][y2][0] - prefixed[x2][y1 - 1][0] + prefixed[x1 - 1][y1 - 1][0]} ${prefixed[x2][y2][1] - prefixed[x1 - 1][y2][1] - prefixed[x2][y1 - 1][1] + prefixed[x1 - 1][y1 - 1][1]} ${prefixed[x2][y2][2] - prefixed[x1 - 1][y2][2] - prefixed[x2][y1 - 1][2] + prefixed[x1 - 1][y1 - 1][2]}\n")
    }
    println(sb)
}
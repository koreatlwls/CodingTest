package september.september04

fun spread(room: List<MutableList<Int>>, r: Int, c: Int) {
    val tmp = List(r) { MutableList(c) { 0 } }
    for (i in 0 until r) {
        for (j in 0 until c) {
            val amount = room[i][j] / 5
            val calc = { I: Int, J: Int ->
                if (room[I][J] != -1) {
                    tmp[I][J] += amount
                    room[i][j] -= amount
                }
            }
            if (i > 0) calc(i - 1, j)
            if (i < r - 1) calc(i + 1, j)
            if (j > 0) calc(i, j - 1)
            if (j < c - 1) calc(i, j + 1)
        }
    }
    for (i in 0 until r) for (j in 0 until c) room[i][j] += tmp[i][j]
}

fun rotate(room: List<MutableList<Int>>, R: Int, C: Int) {
    val left = { r: Int, c1: Int, c2: Int ->
        for (j in c1 + 1..c2) {
            room[r][j - 1] = room[r][j]
        }
    }
    val right = { r: Int, c1: Int, c2: Int ->
        for (j in c2 - 1 downTo c1) {
            if (room[r][j] == -1) room[r][j + 1] = 0 else room[r][j + 1] = room[r][j]
        }
    }
    val up = { r1: Int, r2: Int, c: Int ->
        for (i in r1 + 1..r2) {
            if (room[i - 1][c] != -1) room[i - 1][c] = room[i][c]
        }
    }
    val down = { r1: Int, r2: Int, c: Int ->
        for (i in r2 - 1 downTo r1) {
            if (room[i + 1][c] != -1) room[i + 1][c] = room[i][c]
        }
    }

    val t = room.indexOfFirst { it[0] == -1 }

    down(0, t, 0)
    left(0, 0, C - 1)
    up(0, t, C - 1)
    right(t, 0, C - 1)

    up(t + 1, R - 1, 0)
    left(R - 1, 0, C - 1)
    down(t + 1, R - 1, C - 1)
    right(t + 1, 0, C - 1)
}

private fun main() {
    val (r, c, t) = readLine()!!.split(" ").map { it.toInt() }
    val room = List(r) { readLine()!!.split(" ").map { it.toInt() }.toMutableList() }
    repeat(t) {
        spread(room, r, c)
        rotate(room, r, c)
    }
    println(room.sumOf { it.sum() } + 2)
}

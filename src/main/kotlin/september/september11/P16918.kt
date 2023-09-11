package september.september11

private fun main() {
    val (r, c, n) = readLine()!!.split(" ").map { it.toInt() }
    val x = intArrayOf(-1, 0, 0, 1)
    val y = intArrayOf(0, -1, 1, 0)
    val a = Array(r) { readLine()!!.toCharArray() }
    val b = Array(r) { i -> IntArray(c) { if (a[i][it] == 'O') 3 else 0 } }
    val s = StringBuilder()
    for (t in 2..n) {
        if (t % 2 == 0) {
            for (i in 0 until r) {
                for (j in 0 until c) {
                    if (b[i][j] == 0) {
                        b[i][j] = t + 3; a[i][j] = 'O'
                    }
                }
            }
        } else {
            for (i in 0 until r) {
                for (j in 0 until c) {
                    if (b[i][j] == t) {
                        b[i][j] = 0; a[i][j] = '.'
                        repeat(4) {
                            val h = i + x[it];
                            val w = j + y[it]
                            if (h in 0 until r && w in 0 until c && a[h][w] == 'O' && b[h][w] != t) {
                                b[h][w] = 0; a[h][w] = '.'
                            }
                        }
                    }
                }
            }
        }
    }

    repeat(r) { s.append(a[it]).append('\n') }
    print(s)
}
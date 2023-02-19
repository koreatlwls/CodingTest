package class3

private lateinit var check: Array<BooleanArray>
private lateinit var paper: Array<IntArray>
private val count: IntArray = IntArray(3)

private fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    paper = Array(n) { IntArray(n) }
    check = Array(n) { BooleanArray(n) }

    repeat(n) { idx ->
        paper[idx] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    partitioner(0, 0, n)
    count.forEach { println(it) }
}

private fun check(y: Int, x: Int, n: Int): Boolean {
    val cret = paper[y][x]
    for (i in x until x + n) {
        for (j in y until y + n) {
            if (cret != paper[j][i]) {
                return false
            }
        }
    }

    return true
}

private fun partitioner(y: Int, x: Int, n: Int) {
    if (check(y, x, n)) {
        count[paper[y][x] + 1]++
    } else {
        val s = n / 3
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                partitioner(y + j * s, x + i * s, s)
            }
        }
    }
}
package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private var nm: List<Int> = listOf()
private var matrix: Array<CharArray> = arrayOf()
private val bw = charArrayOf('B', 'W', 'B', 'W', 'B', 'W', 'B', 'W')
private val wb = charArrayOf('W', 'B', 'W', 'B', 'W', 'B', 'W', 'B')

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    nm = readLine()
        .split(" ")
        .map { it.toInt() }

    matrix = Array(nm[0]) { IntArray(nm[1]) }
        .map { readLine().toCharArray() }
        .toTypedArray()

    var xShift = 0
    var yShift = 0
    var min = nm[0] * nm[1]

    while (true) {
        if (yShift + 8 > nm[1]) break

        min = Math.min(min, check(xShift, yShift))

        if (xShift + 8 < nm[0]) xShift++
        else {
            xShift = 0
            yShift++
        }
    }

    println(min)
}

private fun check(x: Int, y: Int): Int {

    var cntW = 0
    var cntB = 0

    for (i in x until x + 8) {

        when (i % 2) {
            0 -> {
                for (j in y until y + 8) {
                    if (bw[j - y] != matrix[i][j])
                        cntB++
                    if (wb[j - y] != matrix[i][j])
                        cntW++
                }
            }
            1 -> {
                for (j in y until y + 8) {
                    if (bw[j - y] != matrix[i][j])
                        cntW++
                    if (wb[j - y] != matrix[i][j])
                        cntB++
                }
            }
        }

    }

    return Math.min(cntW, cntB)
}


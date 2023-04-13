import java.io.BufferedReader
import java.io.InputStreamReader

private var n: Int = 0
private var matrix: Array<IntArray> = arrayOf()

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    n = readLine().toInt()
    matrix = Array(n) { IntArray(n) { Int.MAX_VALUE } }

    repeat(readLine().toInt()) {
        val tmp = readLine()
            .split(" ")
            .map { it.toInt() }
        if (matrix[tmp[0] - 1][tmp[1] - 1] > tmp[2])
            matrix[tmp[0] - 1][tmp[1] - 1] = tmp[2]
    }

    for (i in 0 until n)
        matrix[i][i] = 0

    floydWarshall()
    printMatrix()

}

fun floydWarshall() {
    for (k in 0 until n) {
        for (i in 0 until n) {
            if (matrix[i][k] == Int.MAX_VALUE) continue
            for (j in 0 until n) {
                if (matrix[k][j] == Int.MAX_VALUE) continue
                matrix[i][j] = Math.min(matrix[i][k] + matrix[k][j], matrix[i][j])
            }
        }
    }
}

private fun printMatrix() {
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (matrix[i][j] == Int.MAX_VALUE)
                print("0 ")
            else
                print("${matrix[i][j]} ")
        }
        println()
    }
}
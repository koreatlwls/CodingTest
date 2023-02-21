package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

private lateinit var arr: Array<Array<IntArray>>

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (m, n, h) = readLine().split(" ").map { it.toInt() }

    arr = Array(h) { Array(n) { IntArray(m) } }

    repeat(h) { z ->
        repeat(n) { y ->
            arr[z][y] = readLine().split(" ").map { it.toInt() }.toIntArray()
        }
    }

    val dx = arrayOf(1, -1, 0, 0, 0, 0)
    val dy = arrayOf(0, 0, -1, 1, 0, 0)
    val dz = arrayOf(0, 0, 0, 0, -1, 1)

    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            for (k in arr[i][j].indices) {
                if (arr[i][j][k] == 1) {
                    queue.add(Triple(i, j, k))
                }
            }
        }
    }

    while (queue.isNotEmpty()) {
        val (z, y, x) = queue.poll()

        for (i in 0 until 6) {
            val nx = dx[i] + x
            val ny = dy[i] + y
            val nz = dz[i] + z

            if (nz in 0 until h && ny in 0 until n && nx in 0 until m && arr[nz][ny][nx] == 0) {
                arr[nz][ny][nx] = arr[z][y][x] + 1
                queue.add(Triple(nz, ny, nx))
            }
        }
    }

    println(getResult(arr))
}

private fun getResult(arr: Array<Array<IntArray>>): Int {
    var result = 0

    for (i in arr.indices) {
        for (j in arr[i].indices) {
            for (k in arr[i][j].indices) {
                if (arr[i][j][k] == 0) return -1
                result = max(result, arr[i][j][k])
            }
        }
    }

    return result - 1
}

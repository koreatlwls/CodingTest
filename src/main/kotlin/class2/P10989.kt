package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = System.out.bufferedWriter()
    val n = readLine().toInt()

    val list = IntArray(10001)

    for (i in 0 until n) {
        list[readLine().toInt()]++
    }

    for (i in 1..10000) {
        bw.write("$i\n".repeat(list[i]))
    }

    bw.flush()
    bw.close()
}

package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine(), " ")
        val m = st.nextToken().toInt()
        val n = st.nextToken().toInt()
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        sb.append(calculate(m, n, x, y)).append("\n")
    }

    println(sb)
}

private fun calculate(m: Int, n: Int, x: Int, y: Int): Int {
    var k = x

    while (k <= m * n) {
        if ((k - x) % m == 0 && (k - y) % n == 0) {
            return k
        }
        k += m
    }

    return -1
}

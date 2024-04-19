package dijkstra

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

private var answer = 0
private var cnt = 0

private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, r, c) = br.readLine().split(" ").map { it.toInt() }
    val size = 2.0.pow(n.toDouble()).toInt()

    recurCal(size, 0, 0, r, c)
    println(answer)
}

private fun recurCal(size: Int, rr: Int, cc: Int, r: Int, c: Int) {
    if (rr == r && cc == c) {
        answer = cnt
        return
    }

    if (rr + size > r && rr <= r && cc + size > c && cc <= c) {
        recurCal(size / 2, rr, cc, r, c)
        recurCal(size / 2, rr, cc + size / 2, r, c)
        recurCal(size / 2, rr + size / 2, cc, r, c)
        recurCal(size / 2, rr + size / 2, cc + size / 2, r, c)
    } else {
        cnt += size * size
    }
}

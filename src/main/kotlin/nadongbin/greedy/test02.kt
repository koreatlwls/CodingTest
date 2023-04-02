package nadongbin.greedy

// 숫자 카드 게임

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(" ").map { it.toInt() }

    val map = Array(n){IntArray(m)}
    repeat(n){idx ->
        map[idx]  = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    var answer = 0
    map.forEach { array ->
        val max = array.minOf { it }
        answer = max(answer, max)
    }

    println(answer)
}

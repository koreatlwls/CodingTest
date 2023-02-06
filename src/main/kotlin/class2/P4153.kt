package class2

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()

    while (true) {
        val list = readLine().split(" ").map { it.toDouble() }.sorted()

        if (list.count { it == 0.0 } == 3) break

        sb.append(
            if (
                list[2].pow(2) ==
                list[1].pow(2) + list[0].pow(2)
            ) "right"
            else "wrong"
        ).append("\n")
    }

    println(sb)
}

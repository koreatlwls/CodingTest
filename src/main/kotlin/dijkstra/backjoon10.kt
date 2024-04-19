package dijkstra

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val command = readLine()
        val n = readLine().toInt()
        val arr = readLine().replace("[", "").replace("]", "")
        val deque = ArrayDeque<Int>()

        if (n > 1) {
            arr.split(",").map { it.toInt() }.forEach {
                deque.add(it)
            }
        } else if (n == 1) {
            deque.add(arr.toInt())
        }

        run {
            var isLast = false
            command.forEach {
                if (it == 'D') {
                    if (deque.isNotEmpty()) {
                        if (isLast) {
                            deque.removeLast()
                        } else {
                            deque.removeFirst()
                        }
                    } else {
                        sb.append("error\n")
                        return@run
                    }
                } else {
                    isLast = !isLast
                }
            }

            if (isLast) deque.reverse()
            sb.append(deque.joinToString(",", "[", "]")).append("\n")
        }
    }

    println(sb)
}
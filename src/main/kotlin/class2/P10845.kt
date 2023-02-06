package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    val queue = ArrayDeque<Int>()

    repeat(n){
        val input = readLine()
        when(input){
            "front" -> sb.append(queue.firstOrNull() ?: -1).append("\n")
            "back" -> sb.append(queue.lastOrNull() ?: -1).append("\n")
            "empty" ->sb.append(if(queue.size ==0) 1 else 0).append("\n")
            "size" -> sb.append(queue.size).append("\n")
            "pop" -> sb.append(queue.removeFirstOrNull() ?: -1).append("\n")
            else -> queue.add(input.split(" ")[1].toInt())
        }
    }

    println(sb)
}

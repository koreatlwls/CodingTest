package class2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()

    val stack = Stack<Int>()
    repeat(t) {
        val input = readLine().toInt()

        if (stack.isNotEmpty() && input == 0) {
            stack.pop()
        } else if (input != 0) {
            stack.add(input)
        }
    }

    var sum = 0
    stack.forEach {
        sum += it
    }
    println(sum)
}

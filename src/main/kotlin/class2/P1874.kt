package class2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stack = Stack<Int>()
    val n = readLine().toInt()
    val charList = mutableListOf<Char>()

    var next = readLine().toInt()
    var count = 1

    for (i in 1..n) {
        stack.push(i)
        charList.add('+')

        while (next == stack.peek()) {
            stack.pop()
            charList.add('-')

            if (count < n) {
                next = readLine().toInt()
                count++
            }

            if (stack.isEmpty()) break
        }
    }

    if (stack.isNotEmpty()) println("NO")
    else println(charList.joinToString("\n"))
}

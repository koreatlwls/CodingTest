package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()) {
        val n = readLine().toInt()

        val map = HashMap<String, Int>()

        repeat(n) {
            val input = readLine().split(" ")

            map[input[1]] = map.getOrDefault(input[1], 0) + 1
        }

        var answer = 1
        for ((key, value) in map) {
            answer *= (value + 1)
        }
        println(answer - 1)
    }
}







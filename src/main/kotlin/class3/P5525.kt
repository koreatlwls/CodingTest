package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val inputString = readLine()

    var result = 0
    var continuousIOICount = 0

    for (i in 0..(m - 3)) { // O(3N)
        if (inputString[i] == 'I') {
            if (inputString[i + 1] == 'O' && inputString[i + 2] == 'I') {
                continuousIOICount++
                if (n <= continuousIOICount) result++
            }
            else {
                continuousIOICount = 0
            }
        }
    }

    println(result)
}


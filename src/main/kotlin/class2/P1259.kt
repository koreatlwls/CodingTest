package class2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()

    while (true) {
        val number = readLine().toInt()

        if (number == 0) {
            break
        }

        val numberString = number.toString()

        var isPalindrome = true
        for (i in 0 until numberString.length / 2) {
            if (numberString[i] != numberString[numberString.length - i - 1]) {
                isPalindrome = false
                break
            }
        }

        sb.append(if (isPalindrome) "yes" else "no").append("\n")
    }

    println(sb)
}

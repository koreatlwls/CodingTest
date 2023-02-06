package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val apartment = Array(15) { Array(15) { 0 } }
    for(i in 0..14){
        apartment[0][i] = i
        apartment[i][1] = 1
    }

    for(i in 1..14){
        for(j in 2..14){
            apartment[i][j] = apartment[i-1][j] + apartment[i][j-1]
        }
    }

    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val k = readLine().toInt()
        val n = readLine().toInt()

        sb.append(apartment[k][n]).append("\n")
    }

    println(sb)
}

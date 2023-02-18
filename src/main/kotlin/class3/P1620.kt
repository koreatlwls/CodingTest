package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()

    val (n,m) = readLine().split(" ").map { it.toInt() }

    val idxMap = HashMap<String, Int>()
    val nameMap = HashMap<Int, String>()

    for(i in 1 .. n){
        val input = readLine()

        idxMap[input] = i
        nameMap[i] = input
    }

    repeat(m){
        val input = readLine()

        if(isNumber(input)){
            sb.append(nameMap[input.toInt()]).append("\n")
        }else{
            sb.append(idxMap[input]).append("\n")
        }
    }

    println(sb)
}

private fun isNumber(s: String): Boolean {
    return try {
        s.toInt()
        true
    } catch (ex: NumberFormatException) {
        false
    }
}


package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val arr  = Array(41) { 0 to 0 }.also {
        it[0] = 1 to 0
        it[1] = 0 to 1
    }

    repeat(arr.size){pos ->
        if(pos > 1){
            arr[pos] = arr[pos-1].first + arr[pos-2].first to arr[pos-1].second + arr[pos-2].second
        }
    }


    repeat(readLine().toInt()){
        val n = readLine().toInt()
        sb.append("${arr[n].first} ${arr[n].second}").append("\n")
    }

    println(sb)
}

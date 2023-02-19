package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()

    val n = readLine().toInt()
    val pq = PriorityQueue<Int>()

    repeat(n){
        val input = readLine().toInt()

        if(input == 0){
            if(pq.isNotEmpty()){
                sb.appendLine(pq.poll())
            }else{
                sb.appendLine("0")
            }
        }else{
            pq.add(input)
        }
    }

    println(sb)
}

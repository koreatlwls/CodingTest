package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val n = readLine().toInt()

    val pq = PriorityQueue<Int>(Collections.reverseOrder())

    repeat(n){
        val input = readLine().toInt()

        if(input == 0){
            if(pq.isNotEmpty()){
                sb.append(pq.poll()).append("\n")
            }else{
                sb.append("0\n")
            }
        }else{
            pq.add(input)
        }
    }

    println(sb)
}

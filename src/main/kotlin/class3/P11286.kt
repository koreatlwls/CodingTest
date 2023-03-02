package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val pq = PriorityQueue<Int> { o1, o2 -> if (abs(o1) == abs(o2)) o1 - o2 else abs(o1) - abs(o2) }

    repeat(readLine().toInt()){
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

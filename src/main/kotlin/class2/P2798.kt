package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val list = readLine().split(" ").map { it.toInt() }.sorted()

    var max = 0
    for(i in 0 until N){
        for(j in i+1 until N){
            for(k in j+1 until N){
                val sum = list[i] + list[j] + list[k]
                if(sum in (max + 1)..M){
                    max = sum
                }
            }
        }
    }

    println(max)
}

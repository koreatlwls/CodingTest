package nadongbin.implementation

// 시각

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    var answer = 0
    for(i in 0 .. n){
        for(j in 0 until 60){
            for(k in 0 until 60){
                val time = "$i$j$k"
                if(time.contains('3')){
                    answer++
                }
            }
        }
    }

    println(answer)
}

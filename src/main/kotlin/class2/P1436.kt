package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()

    var num = 666
    var count = 1

    while(count != N){
        num++
        if(num.toString().contains("666")){
            count++
        }
    }

    println(num)
}

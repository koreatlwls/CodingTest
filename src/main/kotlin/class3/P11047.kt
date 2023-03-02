package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (n, k) = readLine().split(" ").map { it.toInt() }

    val list = mutableListOf<Int>()

    repeat(n){
        list.add(readLine().toInt())
    }

    list.sortDescending()

    var i = 0
    var count = 0

    while(k > 0){
        if(k >= list[i]){
            k -= list[i]
            count++
        }else{
            i++
        }
    }

    println(count)
}

package dijkstra

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

private fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val(n,m) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toLong() }.sorted()

    var left = 0L
    var right = list.last()

    var result = 0L
    while(left<= right){
        val mid = (left + right) / 2L

        var check = 0L
        list.forEach {
            if(it > mid){
                check += (it - mid)
            }
        }

        when{
            check >= m -> {
                result = max(result, mid)
                left = mid + 1
            }
            check < m -> {
                right = mid - 1
            }
        }
    }

    println(result)
}
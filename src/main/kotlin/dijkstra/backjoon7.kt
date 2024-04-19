package dijkstra

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() {
    val br  = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(" ").map { it.toInt() }

    val result = mutableListOf<String>()
    val map = HashMap<String, Int>()

    repeat(n){
        val input = br.readLine()
        map[input] = 1
    }

    repeat(m){
        val input = br.readLine()
        if(map.containsKey(input)){
            result.add(input)
        }
    }

    result.sort()
    println(result.size)
    result.forEach { println(it) }
}
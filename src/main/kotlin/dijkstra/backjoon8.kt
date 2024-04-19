package dijkstra

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(n){
        val (a,b) = br.readLine().split(" ").map { it.toInt() }
        list.add(Pair(a,b))
    }

    list.sortWith(compareBy({it.second}, {it.first}))

    val result = mutableListOf<Pair<Int, Int>>()
    result.add(list[0])

    for(i in 1 until list.size){
        val lastTime = result.last().second

        if(list[i].first >= lastTime){
            result.add(list[i])
        }
    }

    println(result.size)
}
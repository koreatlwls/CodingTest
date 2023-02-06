package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val peopleList = mutableListOf<People>()
    repeat(n) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        peopleList.add(People(a, b))
    }

    for(i in 0 until peopleList.size){
        var n = 1
        for(j in 0 until peopleList.size){
            if(i == j)continue
            if(peopleList[i].height < peopleList[j].height && peopleList[i].weight < peopleList[j].weight){
                n++
            }
        }

        peopleList[i] = peopleList[i].copy(rank = n)
    }

    peopleList.forEach {
        print("${it.rank} ")
    }
}

private data class People(
    val weight: Int,
    val height: Int,
    val rank: Int = 0
)
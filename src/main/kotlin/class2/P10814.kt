package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val list = arrayListOf<Pair<Int, String>>()
    repeat(n){
        val (x, y) = readLine().split(" ")
        list.add(Pair(x.toInt(), y))
    }

    val sortedList = list.sortedBy { it.first }
    sortedList.forEach {
        println("${it.first} ${it.second}")
    }
}

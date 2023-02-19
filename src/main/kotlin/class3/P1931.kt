package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val meetings = mutableListOf<Meeting>()

    repeat(n) {
        val (s,e) = readLine().split(" ").map { it.toInt() }
        meetings.add(Meeting(s,e))
    }

    meetings.sortWith(compareBy({it.end}, {it.start}))

    var count = 1
    var e = meetings[0].end
    for(i in 1 until n){
        if(meetings[i].start >= e){
            e = meetings[i].end
            count++
        }
    }

    println(count)
}

private data class Meeting(
    val start: Int,
    val end: Int
)
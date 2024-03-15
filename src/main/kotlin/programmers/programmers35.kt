import kotlin.math.*

class Solution35 {
    fun solution(book_time: Array<Array<String>>): Int {
        var answer: Int = 0

        val list = book_time.map {
            val startSplit = it[0].split(":")
            val endSplit = it[1].split(":")
            Pair(
                startSplit[0].toInt() * 60 + startSplit[1].toInt(),
                endSplit[0].toInt() * 60 + endSplit[1].toInt() + 10,
            )
        }.sortedBy { it.first }

        val arr = IntArray(1500)

        val check = mutableListOf<Int>()
        list.forEach {
            for (i in it.first until it.second) {
                arr[i]++
            }
        }

        arr.forEach {
            answer = max(answer, it)
        }
        return answer
    }
}
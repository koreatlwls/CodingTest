package programmers

// 광물 캐기

private fun solution(picks: IntArray, minerals: Array<String>): Int {
    var answer: Int = 0
    val x = if (minerals.size > picks.sum() * 5) minerals.slice(0 until picks.sum() * 5).toList()
        .chunked(5) else minerals.toList().chunked(5)

    val arr = Array<IntArray>(x.size) { IntArray(3) }
    x.forEachIndexed { index, strings ->
        var d = 0
        var i = 0
        var s = 0
        strings.forEach { v ->
            when (v) {
                "diamond" -> d++
                "iron" -> i++
                else -> s++
            }
        }
        arr[index][0] = d
        arr[index][1] = i
        arr[index][2] = s
    }
    val s = arr.toList().sortedWith(compareBy({ -it[0] }, { -it[1] }, { -it[2] }))

    s.forEach {
        var currentPick = -1
        if (picks[0] != 0) {
            currentPick = 0
            picks[0] -= 1
        } else if (picks[1] != 0) {
            currentPick = 1
            picks[1] -= 1
        } else {
            currentPick = 2
            picks[2] -= 1
        }
        answer += when (currentPick) {
            0 -> it[0] + it[1] + it[2]
            1 -> it[0] * 5 + it[1] + it[2]
            else -> it[0] * 25 + it[1] * 5 + it[2]
        }
    }
    return answer
}

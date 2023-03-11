package programmers

// 호텔 대실

private fun solution(book_time: Array<Array<String>>): Int {
    var answer: Int = 0
    val check = mutableListOf<MutableList<Int>>()
    val timeSort = book_time.toList().sortedBy { it.first() }
    timeSort.forEach {
        val start = it.first().split(":")[0].toInt() * 60 + it.first().split(":")[1].toInt()
        val end = it.last().split(":")[0].toInt() * 60 + it.last().split(":")[1].toInt() + 10
        val team = mutableListOf(start, end)
        if (check.isEmpty()) {
            check.add(team)
        } else {
            var addCheck = true
            for (i in 0 until check.size) {
                if (check[i].last() <= start) {
                    addCheck = false
                    check[i].add(end)
                    break
                }
            }
            if (addCheck) {
                check.add(team)
            }
        }
    }
    answer = check.size
    return answer
}


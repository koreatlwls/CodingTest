package programmers

// 테이블 해시 함수

private fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
    data.sortWith { o1, o2 ->
        if (o1[col - 1] == o2[col - 1]) o2[0] - o1[0]
        else o1[col - 1] - o2[col - 1]
    }
    val s = ArrayList<Int>()
    for (i in row_begin - 1..row_end - 1) {
        var temp = 0
        for (j in data[i].indices) {
            temp += data[i][j] % (i + 1)
        }
        s.add(temp)
    }
    var result = s[0]
    for (i in 1..s.lastIndex) {
        result = result xor s[i]
    }

    return result
}
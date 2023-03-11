package programmers

// 덧칠하기

private fun solution(n: Int, m: Int, section: IntArray): Int {
    var answer: Int = 0

    val wallPaper = BooleanArray(n) { true }
    section.forEach {
        wallPaper[it - 1] = false
    }

    var i = 0
    while (i < n) {
        if (wallPaper[i].not()) {
            answer++
            for (j in 0 until m) {
                if (i + j < n) {
                    wallPaper[i + j] = true
                }
            }
            i += m
        } else {
            i++
        }
    }

    return answer
}
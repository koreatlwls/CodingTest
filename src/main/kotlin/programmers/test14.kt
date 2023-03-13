package programmers

// 인사고과

private fun solution(scores: Array<IntArray>): Int {
    var answer: Int = 0

    val target = scores[0]
    val sortedScores = scores.sortedWith(compareBy({ -it[0] }, { it[1] }))
    var threshold = 0
    sortedScores.forEach {
        if (target[0] < it[0] && target[1] < it[1]) {
            return -1
        }
        if (threshold <= it[1]) {
            if (target[0] + target[1] < it[0] + it[1]) {
                answer++
            }
            threshold = it[1]
        }
    }

    return answer + 1
}

package programmers

// 크기가 작은 부분 문자열

private fun solution(t: String, p: String): Int {
    var answer: Int = 0

    val length = p.length

    for (i in 0 until t.length - length + 1) {
        val nStr = t.substring(i, i + length)
        if (nStr.toLong() <= p.toLong()) {
            answer++
        }
    }

    return answer
}
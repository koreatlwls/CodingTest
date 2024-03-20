package programmers

class Solution44 {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0

        score.sort()
        val abc = score.size / m
        val start = if (score.size % m > 0) score.size % m else 0

        repeat(abc) { idx ->
            answer += (score[start + m * idx] * m)
        }

        return answer
    }
}
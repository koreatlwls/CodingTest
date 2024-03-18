package programmers

class Solution39 {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0
        weights.sort()

        for (i in 0..weights.lastIndex) {
            for (j in i + 1..weights.lastIndex) {

                if (weights[i] == weights[j] || weights[i] * 3 == weights[j] * 2 || weights[i] * 2 == weights[j] || weights[i] * 4 == weights[j] * 3) {
                    answer = answer + 1
                } else if (weights[i] * 2 < weights[j]) {
                    break
                }
            }
        }

        return answer
    }
}
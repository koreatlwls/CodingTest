package programmers

class Solution46 {

    val score = arrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
    var answer = intArrayOf()
    var scoreGap = 0

    fun solution(n: Int, info: IntArray): IntArray {
        dfs(n, info, Array(11) { 0 }, Array(11) { false })

        return if (answer.isEmpty()) intArrayOf(-1) else answer
    }

    fun dfs(n: Int, info: IntArray, rian: Array<Int>, target: Array<Boolean>) {
        if (n <= 0) {
            var apachScore = 0
            var rianScore = 0

            for (i in info.indices) {
                if (rian[i] == 0 && info[i] == 0) continue

                if (rian[i] > info[i]) rianScore += score[i]
                else apachScore += score[i]
            }

            if (rianScore > apachScore) {
                if (rianScore - apachScore >= scoreGap) {
                    answer = rian.toIntArray()
                    scoreGap = rianScore - apachScore
                }
            }

            return
        }

        for (i in info.indices) {
            var arrow = n

            val r = rian.copyOf()
            if (target[i]) continue

            target[i] = true

            if (arrow > info[i]) {
                arrow -= info[i] + 1
                r[i] += info[i] + 1
            }

            if (i == 10) {
                r[i] = arrow
                arrow = 0
            }

            dfs(arrow, info, r, target)
            target[i] = false
        }
    }
}
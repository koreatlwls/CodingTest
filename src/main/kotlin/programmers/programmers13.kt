package programmers

class Solution13 {
    fun solution(targets: Array<IntArray>): Int {
        targets.sortBy { it[0] }

        var answer = 0
        var missileEndLimit = -1

        for (target in targets) {
            val targetMissileStart = target[0]
            val targetMissileEnd = target[1]

            if (targetMissileStart >= missileEndLimit) {
                missileEndLimit = targetMissileEnd
                answer++
            } else {
                missileEndLimit = minOf(missileEndLimit, targetMissileEnd)
            }
        }

        return answer
    }
}
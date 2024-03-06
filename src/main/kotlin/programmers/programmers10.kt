package programmers

class Solution10 {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var answer = 0
        var gcdA = arrayA[0]
        var gcdB = arrayB[0]

        val size = arrayA.size
        for (i in 1 until size) {
            gcdA = GCD(gcdA, arrayA[i])
            gcdB = GCD(gcdB, arrayB[i])
        }

        if (divisable(arrayB, gcdA)) {
            answer = Math.max(answer, gcdA)
        }

        if (divisable(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB)
        }

        return answer
    }

    fun GCD(a: Int, b: Int): Int {
        if (a % b == 0) return b
        return GCD(b, a % b)
    }

    fun divisable(array: IntArray, target: Int): Boolean {
        array.forEach {
            if (it % target == 0) {
                return false
            }
        }

        return true
    }
}
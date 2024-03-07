package programmers

import kotlin.math.*

class Solution14 {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0

        for(r in 1 .. r2){
            val upper = floor(sqrt(r2*r2.toDouble() - r*r.toDouble())).toLong()
            val lower = ceil(sqrt(r1*r1.toDouble() - r*r.toDouble())).toLong()

            answer += upper - lower + 1
        }
        return 4 * answer
    }
}
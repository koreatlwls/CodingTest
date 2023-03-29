package programmers

import kotlin.math.*

// 점 찍기

private fun solution(k: Int, d: Int): Long {
    var answer: Long = 0

    for (i in 0..(d / k)) {
        val longX = i * k
        val longY = (sqrt(d.toDouble().pow(2.0) - longX.toDouble().pow(2.0)) / k).toLong()

        answer += longY + 1L
    }


    return answer
}
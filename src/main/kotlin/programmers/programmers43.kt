package programmers

import kotlin.math.sqrt

class Solution43 {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0

        val range = (1..number)

        for (i in range) {
            val num = findDivisor(i)
            if (num > limit) {
                answer += power
            } else {
                answer += num
            }
        }
        return answer
    }

    fun findDivisor(number: Int): Int {
        val sqrt = sqrt(number.toDouble())
        var count = 0
        for (i in 1..sqrt.toInt()) {
            if (number % i == 0) {
                count++
                if (number / i != i) {
                    count++
                }
            }
        }
        return count
    }
}
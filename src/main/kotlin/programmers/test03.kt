package programmers

import kotlin.math.*

// 연속 펄스 부분 수열의 합

private fun maxMinusMin(sum: LongArray): Long {
    var max = -100001L
    var min = 100001L

    for (i in sum.indices) {
        if (max < sum[i]) {
            max = sum[i]
        }
        if (min > sum[i]) {
            min = sum[i]
        }
    }

    return abs(max - min)
}

private fun solution(sequence: IntArray): Long {
    var answer: Long = 0
    val sum = LongArray(sequence.size + 1)

    for (i in 1 until sum.size) {
        if (i % 2 == 0) {
            sum[i] = sum[i - 1] + sequence[i - 1] * -1
        } else {
            sum[i] = sum[i - 1] + sequence[i - 1]
        }
    }

    answer = maxMinusMin(sum)
    return answer
}

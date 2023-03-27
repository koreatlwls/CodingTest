package programmers

import java.util.*

// 디펜스 게임

private fun solution(n: Int, k: Int, enemy: IntArray): Int {
    var sum = 0
    val pq = PriorityQueue<Int>()

    for (i in enemy.indices) {
        pq.add(enemy[i])

        if (pq.size > k) {
            sum += pq.poll()
        }

        if (sum > n) {
            return i
        }
    }

    return enemy.size
}


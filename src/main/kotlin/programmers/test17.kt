package programmers

import kotlin.math.*

// 이모티콘 할인행사

private fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
    val answer = intArrayOf(0, 0)
    val data = intArrayOf(10, 20, 30, 40)
    val discount = mutableListOf<IntArray>()

    // 이모티콘 할인율 구하기
    fun dfs(temp: IntArray, depth: Int) {
        if (depth == temp.size) {
            discount.add(temp.copyOf())
            return
        }
        for (d in data) {
            temp[depth] += d
            dfs(temp, depth + 1)
            temp[depth] -= d
        }
    }

    dfs(IntArray(emoticons.size), 0)

    // 완전탐색
    for (d in discount.indices) {
        var join = 0
        val price = IntArray(users.size)
        for (e in emoticons.indices) {
            for (u in users.indices) {
                // 할인율을 만족하면 구매
                if (users[u][0] <= discount[d][e]) {
                    price[u] += emoticons[e] * (100 - discount[d][e]) / 100
                }
            }
        }

        // 구매 금액에 따라 가입자 갱신
        for (u in users.indices) {
            if (price[u] >= users[u][1]) {
                join++
                price[u] = 0
            }
        }

        // 최대 가입자, 구매 금액 갱신
        if (join >= answer[0]) {
            if (join == answer[0]) {
                answer[1] = max(answer[1], price.sum())
            } else {
                answer[1] = price.sum()
            }
            answer[0] = join
        }
    }

    return answer
}



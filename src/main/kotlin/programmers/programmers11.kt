package programmers

class Solution11 {
    lateinit var visited: BooleanArray

    fun solution(cards: IntArray): Int {
        visited = BooleanArray(cards.size)

        var group1 = 0
        var group2 = 0

        for (i in cards.indices) {
            if (!visited[i]) {
                visited[i] = true
                val count = dfs(i, cards)

                if (count > group1) {
                    group2 = group1
                    group1 = count
                } else if (count > group2) group2 = count
            }
        }

        return group1 * group2
    }

    fun dfs(idx: Int, cards: IntArray): Int {
        var count = 1
        val nextBoxIdx = cards[idx] - 1

        if (!visited[nextBoxIdx]) {
            visited[nextBoxIdx] = true
            count = dfs(nextBoxIdx, cards) + 1
        }

        return count
    }
}
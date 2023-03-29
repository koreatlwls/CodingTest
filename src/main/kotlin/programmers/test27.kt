package programmers

// 가장 가까운 글자

private fun solution(s: String): IntArray {
    val answer = IntArray(s.length)

    val map = HashMap<Char, Int>()

    s.forEachIndexed { idx, value ->
        if (map.containsKey(value)) {
            answer[idx] = idx - map[value]!!
            map[value] = idx
        } else {
            map[value] = idx
            answer[idx] = -1
        }
    }

    return answer
}
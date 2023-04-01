package programmers

// 추억 점수

private fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
    val answer = IntArray(photo.size)

    val map = HashMap<String, Int>()
    name.forEachIndexed { idx, value ->
        map[value] = yearning[idx]
    }

    photo.forEachIndexed { idx, test ->
        test.forEach {
            answer[idx] += map.getOrDefault(it, 0)
        }
    }

    return answer
}

package programmers

// 둘만의 암호

private fun solution(s: String, skip: String, index: Int): String {
    var answer: String = ""
    val alph = "abcdefghijklmnopqrstuvwxyz"

    val alphabet = BooleanArray(26)
    skip.forEach {
        val idx = it - 'a'
        alphabet[idx] = true
    }

    s.forEach {
        var idx = it - 'a'
        var cnt = 0
        while (true) {
            if (cnt == index) {
                break
            }

            idx++
            if (idx > 25) {
                idx = 0
            }
            if (alphabet[idx].not()) {
                cnt++
            }
        }

        answer += alph.get(idx)
    }

    return answer
}
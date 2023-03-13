package programmers

// 개인정보 수집 유효기간

private fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
    var answer = mutableListOf<Int>()

    val todayLong = makeLong(today)

    val map = HashMap<String, Int>()
    terms.forEach {
        val splitStr = it.split(" ")
        map[splitStr[0]] = splitStr[1].toInt()
    }

    privacies.forEachIndexed { idx, value ->
        val splitValue = value.split(" ")
        val day = splitValue[0]
        val type = map[splitValue[1]]!!

        val dayLong = makeLong(day)
        val check = dayLong + type * 28

        if (todayLong >= check) {
            answer.add(idx + 1)
        }
    }

    return answer.sorted().toIntArray()
}

private fun makeLong(input: String): Long {
    var answer = 0L
    val splitInput = input.split(".")

    answer += (splitInput[0].toInt() * 28 * 12)
    answer += ((splitInput[1].toInt() - 1) * 28)
    answer += splitInput[2].toInt()
    return answer
}

package programmers

// 카드 뭉치

private fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
    var answer: String = ""
    var firstCnt = 0
    var secondCnt = 0
    var check = true

    for (str in goal) {
        if (firstCnt < cards1.size && str == cards1[firstCnt]) {
            firstCnt++
        } else if (secondCnt < cards2.size && str == cards2[secondCnt]) {
            secondCnt++
        } else {
            check = false
        }
    }

    answer = if (check) "Yes" else "No"

    return answer
}

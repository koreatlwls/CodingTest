package programmers

class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0

        val checkList = listOf("aya", "ye", "woo", "ma")

        babbling.forEach {
            var temp = it
            for (check in checkList) {
                if (temp.contains(check + check)) {
                    continue
                } else {
                    temp = temp.replace(check, " ")
                }
            }
            if (temp.replace(" ", "").isEmpty()) {
                answer++
            }
        }

        return answer
    }
}
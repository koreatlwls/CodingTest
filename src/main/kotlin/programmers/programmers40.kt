package programmers

class Solution40 {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val answer = mutableListOf<Int>()

        val termsDate = mutableMapOf<String, Int>()
        terms.forEach {
            val splitTerms = it.split(" ")
            termsDate[splitTerms[0]] = splitTerms[1].toInt() * 28 - 1
        }

        val todayLong = getDate(today)

        privacies.forEachIndexed { index, privacy ->
            val splitStr = privacy.split(" ")
            val date = getDate(splitStr[0])
            val terms = termsDate[splitStr[1]]!!

            val updateDate = date + terms
            if (todayLong > updateDate) {
                answer.add(index + 1)
            }
        }

        return answer.toIntArray()
    }

    fun getDate(str: String): Long {
        val splitStr = str.split(".")
        return splitStr[0].toLong() * 12 * 28 + splitStr[1].toLong() * 28 + splitStr[2].toLong()
    }
}
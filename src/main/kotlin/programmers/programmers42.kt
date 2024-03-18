package programmers

class Solution42 {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        data.sortWith(compareBy<IntArray> { it[col - 1] }.thenBy { -it[0] })
        val range = (row_begin - 1)..<row_end

        val resultList = mutableListOf<Int>(0)
        for (i in range) {
            var result = 0
            data[i].forEach {
                result += it % (i + 1)
            }
            resultList.add(result)
        }

        var answer = resultList[0]
        for (i in 1 until resultList.size) {
            answer = answer xor resultList[i]
        }
        return answer
    }
}
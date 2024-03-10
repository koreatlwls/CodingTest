package programmers

class Solution18 {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = IntArray(2)

        val list = test((brown + yellow).toLong())

        for (pair in list) {
            val br = pair.first + pair.first + pair.second - 2L + pair.second - 2L
            if (brown.toLong() == br) {
                answer[0] = pair.second.toInt()
                answer[1] = pair.first.toInt()
                break
            }
        }
        return answer
    }

    fun test(num: Long): List<Pair<Long, Long>> {
        val list = mutableListOf<Pair<Long, Long>>()
        for (i in 3 until num) {
            if (num % i == 0L) {
                list.add(Pair(i.toLong(), (num / i).toLong()))
            }
        }

        return list
    }
}
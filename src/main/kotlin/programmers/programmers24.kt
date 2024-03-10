package programmers

class Solution24 {
    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        val answer = mutableListOf<Double>()

        val arr = mutableListOf<Int>()
        arr.add(k)
        var next = k

        while (next != 1) {
            if (next % 2 == 0) next /= 2
            else next = next * 3 + 1
            arr.add(next)
        }

        val area = DoubleArray(arr.size) {
            0.0
        }

        for (i in 1 until arr.size) {
            area[i] = (arr[i] + arr[i - 1]) / 2.toDouble()
        }

        val sum = DoubleArray(arr.size) {
            0.0
        }

        for (i in 1 until arr.size) {
            sum[i] = sum[i - 1] + area[i]
        }


        ranges.forEach { range ->
            val a = range[0]
            val b = (arr.size - 1) + range[1]

            if (a > b) answer.add(-1.0)
            else {
                answer.add(sum[b] - sum[a])
            }
        }

        return answer.toDoubleArray()
    }
}
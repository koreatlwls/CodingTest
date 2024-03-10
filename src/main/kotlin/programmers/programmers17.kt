package programmers

class Solution17 {
    fun solution(n: Int): IntArray {
        val arr = Array<IntArray>(n) { IntArray(n) }
        var (x, y) = arrayOf(0, -1)

        (1..n).forEach { i ->
            repeat(n - i + 1) { j ->
                val l = (n - i + 2..n).sum() + j + 1

                when (i % 3) {
                    1 -> y++
                    2 -> x++
                    else -> {
                        y--
                        x--
                    }
                }

                arr[y][x] = l
            }
        }

        return arr.flatMap { it.filter { value -> value != 0 } }.toIntArray()
    }
}
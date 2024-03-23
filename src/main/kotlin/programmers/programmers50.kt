package programmers

import java.util.*

class Solution50 {
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0

        val stack = Stack<Int>()

        ingredient.forEach {
            stack.add(it)

            if (stack.peek() == 1 && stack.size >= 4) {
                val first = stack[stack.size - 4]
                val second = stack[stack.size - 3]
                val third = stack[stack.size - 2]
                val fourth = stack[stack.size - 1]

                if (first == 1 && second == 2 && third == 3 && fourth == 1) {
                    answer++
                    repeat(4) {
                        stack.pop()
                    }
                }
            }
        }

        return answer
    }
}
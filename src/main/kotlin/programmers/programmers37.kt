package programmers

import java.util.*

class Solution37 {
    fun solution(numbers: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val stack = Stack<Int>()

        for (i in numbers.lastIndex downTo 0) {
            var maxNum = -1
            while (stack.isNotEmpty()) {
                if (stack.peek() > numbers[i]) {
                    maxNum = stack.peek()
                    break
                } else {
                    stack.pop()
                }
            }
            answer.add(maxNum)
            stack.push(numbers[i])
        }
        return answer.reversed().toIntArray()
    }
}
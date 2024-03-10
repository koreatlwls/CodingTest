package programmers

import java.util.*

class Solution19 {
    fun solution(number: String, k: Int): String {
        var answer = ""
        var count = k
        val stack = Stack<Char>()

        number.forEach {
            while(stack.isNotEmpty() && stack.peek() < it && count >0){
                stack.pop()
                count--;
            }
            stack.push(it)
        }

        for(i in 1..count) stack.pop()

        return  stack.toArray().joinToString("")
    }
}
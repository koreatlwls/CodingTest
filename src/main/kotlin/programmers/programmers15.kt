package programmers

import java.util.*

class Solution15 {
    fun solution(s: String): Int {
        return s.indices.count { isTrue(s.substring(it, s.length) + s.substring(0, it)) }
    }

    fun isTrue(s: String): Boolean {
        val openBracket = charArrayOf('(', '{', '[')
        val closeBracket = charArrayOf(')', '}', ']')
        val stack = Stack<Char>()
        var flag = false

        for (c in closeBracket) if (c == s[0]) return false

        for (c in s) {
            flag = false
            for (i in openBracket.indices)
                if (stack.isNotEmpty() && stack.peek() == openBracket[i] && c == closeBracket[i])
                    flag = true
            if (flag) stack.pop()
            else stack.add(c)
        }

        return stack.isEmpty()
    }
}
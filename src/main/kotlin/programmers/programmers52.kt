package programmers

class Solution52 {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0

        var coke = 0
        var emptyCoke = n

        while(coke + emptyCoke >= a) {
            val result = (emptyCoke / a).toInt() * b
            coke += result
            emptyCoke = emptyCoke % a
            emptyCoke += coke
            coke = 0
            answer += result
        }
        return answer
    }
}
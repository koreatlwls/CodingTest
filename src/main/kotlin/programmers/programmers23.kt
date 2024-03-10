package programmers

import java.util.*

class Solution23 {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer = IntArray(score.size)

        val pq = PriorityQueue<Int>()
        score.forEachIndexed { index, sc ->
            if(pq.size >= k){
                if(pq.peek() < sc){
                    pq.poll()
                    pq.add(sc)
                }
            }else{
                pq.add(sc)
            }

            answer[index] = pq.peek()
        }
        return answer
    }
}
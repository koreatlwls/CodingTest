package programmers

class Solution1 {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var l = 0
        var r = 0
        var sum = sequence[r]
        var answer = intArrayOf(0,Int.MAX_VALUE)

        while(l < sequence.size){
            if(sum < k){
                if(r == sequence.size-1) break
                sum += sequence[++r]
            }else{
                if(sum == k){
                    if(answer[1]-answer[0] > r-l){
                        answer[0] = l
                        answer[1] = r
                    }
                }
                sum -= sequence[l++]
            }
        }
        return answer
    }
}
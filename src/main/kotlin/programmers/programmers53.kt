package programmers

class Solution53 {
    fun solution(number: IntArray): Int {
        var answer: Int = 0

        val indexSet = hashSetOf<IntArray>()
        for(i in 0 until number.size){
            for(j in i + 1 until number.size){
                for(k in j + 1 until number.size){
                    if(number[i] + number[j] + number[k] == 0){
                        val curIndex = intArrayOf(i, j, k)
                        if(indexSet.contains(curIndex)) continue
                        else{
                            answer++
                            indexSet.add(curIndex)
                        }
                    }
                }
            }
        }
        return answer
    }
}
package programmers

class Solution12 {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        val map = mutableMapOf<String, Int>()

        want.forEachIndexed { index, s ->
            map[s] = number[index]
        }

        var count = 0
        for(i in 0..discount.size -10){
            val copy = map.toMutableMap()
            for(j in 0 until 10 ){
                copy[discount[i+j]] = copy[discount[i+j]]?.minus(1)?:-1
            }

            if(copy.all { it.value === 0 }) count++
        }
        return count
    }
}
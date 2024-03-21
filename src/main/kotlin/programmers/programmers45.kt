package programmers

class Solution45 {
    fun solution(food: IntArray): String {
        var test = ""
        for(i in 1 until food.size){
            repeat(food[i] / 2){
                test += i.toString()
            }
        }

        return "${test}0${test.reversed()}"
    }
}
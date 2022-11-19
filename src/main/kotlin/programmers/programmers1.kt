package programmers

fun solution(topping: IntArray): Int {
    val countSave = mutableMapOf<Int, Int>()
    topping.forEach { countSave[it] = (countSave[it] ?: 0) + 1 }

    var count = 0
    val input = mutableSetOf<Int>()

    topping.forEach {
        if(countSave[it] == 1){
            countSave.remove(it)
        }else{
            countSave[it] = countSave[it]!! - 1
        }

        input.add(it)
        if(input.size == countSave.size) count++
    }

    return count
}

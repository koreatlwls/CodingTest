package programmers

fun solution(clothes : Array<Array<String>>) : Int {

    val clothesMap : HashMap<String, Int> = HashMap()

    clothes.forEach {
        if(clothesMap.containsKey(it[1])){
            clothesMap[it[1]] = (clothesMap[it[1]] ?: 1) + 1
        }else{
            clothesMap[it[1]] = 1
        }
    }

    val answer = clothesMap.values.fold(1){
        acc, i -> acc * (i+1)
    }

    return answer - 1
}
package programmers

fun solution(priorities : IntArray, location : Int) : Int{
    val printQueue = priorities.withIndex().toMutableList()
    var count = 0

    while(printQueue.isNotEmpty()){
        val current : IndexedValue<Int> = printQueue.first()
        printQueue.removeAt(0)
        if(printQueue.any{current.value < it.value}){
            printQueue.add(current)
        }else{
            count += 1
            if(location == current.index){
                break
            }
        }
    }

    return count
}
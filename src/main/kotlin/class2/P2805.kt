package class2

import java.io.BufferedReader
import java.io.InputStreamReader

//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val (N, M) = readLine().split(" ").map { it.toInt() }
//    val list = readLine().split(" ").map { it.toLong() }
//
//    println(binSearch(list, M))
//}
//
//fun binSearch(list: List<Long>, target: Int): Long {
//    var high = list.maxOrNull()!!
//    var low = 0L
//    var mid = 0L
//
//    while(low <= high){
//        mid = (high + low) / 2
//        val number = check(list, mid)
//
//        when{
//            number >= target -> low = mid + 1
//            else -> high = mid -1
//        }
//    }
//
//    return high
//}
//
//fun check(list : List<Long>, cut : Long) : Long{
//    var sum = 0L
//    list.forEach {
//        if(it > cut)
//            sum += (it-cut)
//    }
//
//    return sum
//}



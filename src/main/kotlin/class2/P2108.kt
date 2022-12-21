package class2

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.roundToInt

//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val N = readLine().toInt()
//
//    val hashMap = HashMap<Int, Int>()
//    val inputList = mutableListOf<Int>()
//
//    var sum = 0.0
//    repeat(N) {
//        val tmp = readLine().toInt()
//        sum += tmp
//
//        inputList.add(tmp)
//
//        if (!hashMap.containsKey(tmp)) hashMap[tmp] = 0
//        hashMap[tmp] = hashMap[tmp]!! + 1
//    }
//
//    val average = (sum / N).roundToInt()
//    println(average)
//
//    val sortedList = inputList.sorted()
//    println(sortedList[N / 2])
//
//    val list = hashMap.toList().sortedBy { (k, _) -> k }
//
//    var max = 0
//    var answer = 0
//    var count = 0
//    for ((k, v) in list) {
//        if(v > max){
//            count = 1
//            answer = k
//            max = v
//        }else if(v == max){
//            count++
//            if(count == 2){
//                answer = k
//            }
//        }
//    }
//    println(answer)
//
//    println(sortedList.maxOrNull()!! - sortedList.minOrNull()!!)
//}

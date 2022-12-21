package class2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val st = StringTokenizer(readLine())
//    val k = st.nextToken().toInt()
//    val n = st.nextToken().toInt()
//    val cables = IntArray(n)
//
//    repeat(k) {
//        cables[it] = readLine().toInt()
//    }
//
//    var max = cables.maxOrNull()!!
//    var min = 1
//    var answer = 0
//
//    while (min <= max) {
//        val mid = min + (max - min) / 2
//        var count = 0
//
//        cables.forEach { count += it / mid }
//
//        if (count >= n) {
//            answer = mid
//
//            if (min == Int.MAX_VALUE) break
//            min = mid + 1
//        } else {
//            max = mid - 1
//        }
//    }
//
//    println(answer)
//}

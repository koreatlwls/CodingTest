package class2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val t = readLine().toInt()
//
//    for (i in 0 until t) {
//        var (n, m) = readLine().split(" ").map { it.toInt() }
//        val queue = LinkedList<Int>()
//        var count = 0
//
//        val list = readLine().split(" ").map { it.toInt() }
//        for (j in 0 until n) {
//            queue.offerLast(list[j])
//        }
//
//        while (queue.size > 0) {
//            val maximum = queue.maxOrNull()
//            val front = queue.pollFirst()
//            m -= 1
//
//            if (maximum == front) {
//                count += 1
//                if (m < 0) {
//                    println(count)
//                    break
//                }
//            } else {
//                queue.offerLast(front)
//                if (m < 0) {
//                    m = queue.size - 1
//                }
//            }
//        }
//    }
//}
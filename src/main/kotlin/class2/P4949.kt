package class2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val sb = StringBuilder()
//
//    while (true) {
//        val input = readLine()
//
//        if (input == ".") {
//            break
//        }
//
//        val stack = Stack<Char>()
//        var isBalanced = true
//        input.forEach {
//            if (it == '(' || it == '[') {
//                stack.add(it)
//            } else if (it == ']') {
//                if (stack.isNotEmpty() && stack.peek() == '[') {
//                    stack.pop()
//                } else {
//                    isBalanced = false
//                    return@forEach
//                }
//            } else if (it == ')') {
//                if (stack.isNotEmpty() && stack.peek() == '(') {
//                    stack.pop()
//                } else {
//                    isBalanced = false
//                    return@forEach
//                }
//            }
//        }
//
//        if (stack.isNotEmpty()) {
//            isBalanced = false
//        }
//
//        val result = if (isBalanced) "yes" else "no"
//        sb.append(result).append("\n")
//    }
//
//    println(sb)
//}

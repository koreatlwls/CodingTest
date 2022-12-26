package class2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val sb = StringBuilder()
//
//    val n = readLine().toInt()
//
//    repeat(n){
//        val input = readLine()
//
//        val stack = Stack<Char>()
//        var isBalanced = true
//        input.forEach {
//            if(it == '(' || it == '['){
//                stack.add(it)
//            }else if(it == ')'){
//                if(stack.isNotEmpty() && stack.peek() == '('){
//                    stack.pop()
//                }else{
//                    isBalanced = false
//                    return@forEach
//                }
//            }else if(it == ']'){
//                if(stack.isNotEmpty() && stack.peek() == '['){
//                    stack.pop()
//                }else{
//                    isBalanced = false
//                    return@forEach
//                }
//            }
//        }
//
//        if(stack.isNotEmpty()){
//            isBalanced = false
//        }
//
//        val result = if(isBalanced) "YES" else "NO"
//        sb.append(result).append("\n")
//    }
//
//    println(sb)
//}

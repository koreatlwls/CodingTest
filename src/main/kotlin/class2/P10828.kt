package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var stack: IntArray
private var index = -1

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    stack = IntArray(n) { 0 }
    repeat(n) {
        val input = readLine()
        when (input) {
            "top" -> println(top())
            "pop" -> println(pop())
            "empty" -> println(empty())
            "size" -> println(size())
            else -> push(input.split(" ")[1].toInt())
        }
    }
}

private fun top() : Int = if(index == -1) -1 else stack[index]
private fun pop() : Int = if(index==-1) -1 else stack[index--]
private fun empty() : Int = if(index==-1) 1 else 0
private fun size() : Int = index + 1
private fun push(value : Int){
    stack[++index] = value
}
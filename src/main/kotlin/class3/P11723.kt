package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private val set = mutableSetOf<Int>()

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val input = readLine().split(" ")
        when (input[0]) {
            "add" -> add(input[1].toInt())
            "remove" -> remove(input[1].toInt())
            "check" -> sb.append(check(input[1].toInt())).append("\n")
            "toggle" -> toggle(input[1].toInt())
            "all" -> all()
            else -> empty()
        }
    }
    println(sb)
}

private fun add(num: Int) {
    set.add(num)
}

private fun remove(num: Int) {
    set.remove(num)
}

private fun check(num: Int): String {
    return if (set.contains(num)) {
        "1"
    } else {
        "0"
    }
}

private fun toggle(num: Int) {
    if (set.contains(num)) {
        set.remove(num)
    } else {
        set.add(num)
    }
}

private fun all() {
    repeat(20) { idx ->
        set.add(idx + 1)
    }
}

private fun empty() {
    repeat(20) { idx ->
        set.remove(idx + 1)
    }
}


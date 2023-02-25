package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val t = readLine().toInt()

        val treeMap = TreeMap<Int, Int>()

        for (i in 0 until t) {
            val input = readLine().split(" ")
            val command = input[0]
            val data = input[1].toInt()

            if (command == "I") {
                treeMap[data] = treeMap.getOrDefault(data, 0) + 1
            } else {
                if (treeMap.size == 0) continue
                val key = if (data == 1) treeMap.lastKey() else treeMap.firstKey()
                val keyCnt = treeMap[key]!!
                if (keyCnt == 1) treeMap.remove(key)
                else treeMap[key] = keyCnt - 1
            }
        }

        if (treeMap.size == 0) sb.append("EMPTY\n")
        else {
            sb.append("${treeMap.lastKey()} ${treeMap.firstKey()}\n")
        }
    }

    println(sb)
}

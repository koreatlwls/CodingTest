package programmers

import kotlin.math.*

// 대충 만든 자판

private fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
    val answer = IntArray(targets.size) { -1 }

    val map = mutableMapOf<Char, Int>()

    keymap.forEach {
        val arr = it.toCharArray()
        arr.forEach {
            if (map.containsKey(it)) {
                map[it] = min(map[it]!!, arr.indexOf(it) + 1)
            } else {
                map[it] = arr.indexOf(it) + 1
            }
        }
    }

    for (i in targets.indices) {
        val arr = targets[i].toCharArray()
        var count = 0
        var flag = true
        for (j in arr.indices) {
            if (map.containsKey(arr[j])) {
                count += map[arr[j]]!!
            } else {
                flag = false
                break
            }
        }
        if (flag) answer[i] = count
    }

    return answer
}

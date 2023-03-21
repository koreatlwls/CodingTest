package programmers

import kotlin.math.floor
import kotlin.math.ln
import kotlin.math.pow

// 표현 가능한 이진트리

private lateinit var target: BooleanArray
private var result = 0

private fun solve(s: Int, e: Int, isEnd: Boolean) {
    val mid = (s + e) / 2
    val cur = target[mid]

    if (isEnd && cur) {
        result = 0
        return
    }

    if (s != e) {
        solve(s, mid - 1, !cur)
        solve(mid + 1, e, !cur)
    }
}

fun solution(numbers: LongArray): IntArray {
    val res = IntArray(numbers.size)
    for (ind in numbers.indices) {
        result = 1
        var num = numbers[ind]

        val len = floor(ln(num.toDouble()) / ln(2.0)).toInt() + 1

        var exp = 1
        var treeLen = 0
        while (true) {
            treeLen = 2.0.pow(exp++.toDouble()).toInt() - 1
            if (treeLen >= len) break
        }
        target = BooleanArray(treeLen)
        var i = treeLen - 1
        while (true) {
            val div = num / 2
            val mod = num % 2
            num = div
            target[i--] = mod == 1L
            if (div == 1L) {
                target[i] = true
                break
            } else if (div == 0L) break
        }
        solve(0, treeLen - 1, false)
        res[ind] = result
    }
    return res
}

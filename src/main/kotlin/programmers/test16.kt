package programmers

import java.util.*
import kotlin.math.max

// 택배 배달과 수거하기

private fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
    var answer: Long = 0

    val dStack = Stack<Int>()
    val pStack = Stack<Int>()
    for (i in 0 until n) {
        if (deliveries[i] > 0) {
            dStack.add(i)
        }
        if (pickups[i] > 0) {
            pStack.add(i)
        }
    }

    while (dStack.isNotEmpty() && pStack.isNotEmpty()) {
        answer += max((dStack.peek() + 1) * 2, (pStack.peek() + 1) * 2)

        var box = 0
        while (dStack.isNotEmpty() && box <= cap) {
            if (deliveries[dStack.peek()] + box <= cap) {
                box += deliveries[dStack.peek()]
            } else {
                deliveries[dStack.peek()] -= (cap - box)
                break
            }
            dStack.pop()
        }

        box = 0
        while (pStack.isNotEmpty() && box <= cap) {
            if (pickups[pStack.peek()] + box <= cap) {
                box += pickups[pStack.peek()]
            } else {
                pickups[pStack.peek()] -= (cap - box)
                break
            }
            pStack.pop()
        }
    }

    while (dStack.isNotEmpty()) {
        answer += (dStack.peek() + 1) * 2

        var box = 0
        while (dStack.isNotEmpty() && box <= cap) {
            if (deliveries[dStack.peek()] + box <= cap) {
                box += deliveries[dStack.peek()]
            } else {
                deliveries[dStack.peek()] -= (cap - box)
                break
            }
            dStack.pop()
        }
    }

    while (pStack.isNotEmpty()) {
        answer += (pStack.peek() + 1) * 2

        var box = 0
        while (pStack.isNotEmpty() && box <= cap) {
            if (pickups[pStack.peek()] + box <= cap) {
                box += pickups[pStack.peek()]
            } else {
                pickups[pStack.peek()] -= (cap - box)
                break
            }
            pStack.pop()
        }
    }

    return answer
}

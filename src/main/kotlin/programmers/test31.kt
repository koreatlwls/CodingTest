package programmers

import java.util.*

// 과제 진행하기

private fun solution(plans: Array<Array<String>>): Array<String> {
    val answer = mutableListOf<String>()
    val sortedPlans = plans.sortedBy { it[1].toTime() }
    val stack = Stack<Pair<String, Int>>()
    var cTime = 0

    for (i in sortedPlans.indices) {
        val c = sortedPlans[i]

        while (stack.isNotEmpty()) {
            val p = stack.pop()!!

            if (p.second > c[1].toTime() + cTime * -1) {
                // 기존 작업과 새 작업이 겹쳤을 때
                stack.push(p.first to cTime + p.second + c[1].toTime() * -1)
                break
            } else {
                // 기존 작업과 새 작업이 겹치지 않을 때
                cTime += p.second
                answer.add(p.first)
            }
        }

        cTime = c[1].toTime()
        stack.push(c[0] to c[2].toInt())
    }

    // 남은 작업 순차적으로 처리
    while (stack.isNotEmpty()) {
        answer.add(stack.pop()!!.first)
    }

    return answer.toTypedArray()
}

// 시간 문자를 분 숫자로 변환
private fun String.toTime(): Int {
    val t = this.replace(":", "").toInt()
    return t / 100 * 60 + t % 100
}

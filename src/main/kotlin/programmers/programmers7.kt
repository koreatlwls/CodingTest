package programmers

class Solution7 {

    val orderMap = mutableMapOf<String, Int>()

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val answer = mutableListOf<String>()

        val sortedOrders = orders.map {
            it.toMutableList().sorted().joinToString("")
        }

        course.map { course ->
            orderMap.clear()

            sortedOrders.forEach { order ->
                combi(course, 0, order)
            }

            val maxKey = orderMap.maxOfOrNull { it.value } ?: 0

            if (maxKey >= 2) {
                orderMap.filter { it.value == maxKey }.map {
                    answer.add(it.key)
                }
            }
        }

        return answer.sorted().toTypedArray()
    }

    var ordercombi = ""
    fun combi(course: Int, now: Int, order: String) {
        if (course <= 0) {
            orderMap[ordercombi] = orderMap.getOrDefault(ordercombi, 0) + 1
            return
        }

        for (i in now until order.length) {
            ordercombi += order[i]
            combi(course - 1, i + 1, order)
            ordercombi = ordercombi.dropLast(1)
        }
    }
}
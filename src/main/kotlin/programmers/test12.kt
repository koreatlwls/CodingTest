package programmers

import java.util.*

// 숫자 변환하기

private fun solution(x: Int, y: Int, n: Int): Int {
    return bfs(x, y, n)
}

private fun bfs(start: Int, end: Int, n: Int): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(start, 0))
    val visited = BooleanArray(end + 1)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val now = queue.poll()

        if (now.first == end) {
            return now.second
        }

        val first = now.first + n
        val second = now.first * 2
        val third = now.first * 3

        if (first <= end && visited[first].not()) {
            visited[first] = true
            queue.add(Pair(first, now.second + 1))
        }
        if (second <= end && visited[second].not()) {
            visited[second] = true
            queue.add(Pair(second, now.second + 1))
        }
        if (third <= end && visited[third].not()) {
            visited[third] = true
            queue.add(Pair(third, now.second + 1))
        }
    }

    return -1
}
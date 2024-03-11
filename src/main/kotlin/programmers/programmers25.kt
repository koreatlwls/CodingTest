package programmers

import java.util.*
import kotlin.math.*

class Solution25 {

    data class Answer(val summit: Int, val intensity: Int)

    data class Node(val index: Int, val distance: Int = 0) : Comparable<Node> {
        override fun compareTo(other: Node): Int =
            distance - other.distance
    }

    lateinit var graph: List<PriorityQueue<Node>>

    fun solution(n: Int, paths: Array<IntArray>, gates: IntArray, summits: IntArray): IntArray {

        graph = List(n + 1) { PriorityQueue<Node>() }

        paths.forEach { (from, to, weight) ->
            if (from in summits || to in gates) {
                graph[to].add(Node(from, weight))
            } else if (to in summits || from in gates) {
                graph[from].add(Node(to, weight))
            } else {
                graph[from].add(Node(to, weight))
                graph[to].add(Node(from, weight))
            }
        }

        val result = dijkstra(gates, summits.sorted(), n)

        return intArrayOf(result.summit, result.intensity)
    }

    fun dijkstra(gates: IntArray, summits: List<Int>, n: Int): Answer {
        val pq = PriorityQueue<Node>()
        val result = IntArray(n + 1) { Int.MAX_VALUE }

        gates.forEach { gate ->
            pq.add(Node(gate))
            result[gate] = 0
        }

        while (pq.isNotEmpty()) {
            val (now, distance) = pq.poll()

            if (distance > result[now]) continue

            for (to in graph[now]) {
                val cost = max(to.distance, result[now])
                if (cost < result[to.index]) {
                    result[to.index] = cost
                    pq.add(Node(to.index, cost))
                }
            }
        }

        return summits.map { Answer(it, result[it]) }.minByOrNull { it.intensity }!!
    }
}
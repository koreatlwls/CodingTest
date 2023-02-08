package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    data class Point(
        val a: Int,
        val b: Int
    ) : Comparable<Point> {
        override fun compareTo(other: Point): Int = compareValuesBy(this, other, { it.b }, { it.a })
    }

    val list = mutableListOf<Point>()

    repeat(readLine().toInt()) {
        val (a, b) = readLine().split(" ").map { it.toInt() }

        list.add(Point(a, b))
    }

    list.sorted().forEach {
        println("${it.a} ${it.b}")
    }
}



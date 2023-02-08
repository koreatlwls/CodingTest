package class2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val queue = LinkedList<Int>()
    val list = mutableListOf<Int>()

    for (i in 1.. n) {
        queue.offerLast(i)
    }

    var count = 1

    while (queue.size > 0) {
        if (count % m == 0) {
            list.add(queue.pollFirst())
        }
        else {
            queue.offerLast(queue.pollFirst())
        }
        count += 1
    }

    print("<")
    for (i in list) {
        if (i == list.last()) {
            print("$i")
        }
        else {
            print("$i, ")
        }
    }
    print(">")
}

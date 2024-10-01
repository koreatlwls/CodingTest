private data class Monitor (
    val idx : Int,
    val w : Int,
    val h : Int,
)

private fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = mutableListOf<Monitor>()
    repeat(n){ idx ->
        val (w,h) = readLine().split(" ").map { it.toInt() }
        list.add(Monitor(idx + 1,w,h))
    }

    val update = list.sortedByDescending { it.w * it.w + it.h * it.h }
    update.forEach {
        println(it.idx)
    }
}
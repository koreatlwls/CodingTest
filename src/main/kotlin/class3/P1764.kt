package class3

private fun main() = with(System.`in`.bufferedReader()) {
    val set = mutableSetOf<String>()
    val list = mutableListOf<String>()
    val (N, M) = readLine().split(' ').map { it.toInt() }

    repeat(N) { set.add(readLine()) }
    repeat(M) {
        val s = readLine()
        if (set.contains(s)) list.add(s)
    }

    val sb = StringBuilder().appendLine(list.size)
    list.sorted().forEach { sb.appendLine(it) }
    print(sb)
}
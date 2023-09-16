package september.september16

private fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }.sorted()
    fun go(i: Int, s: List<Int>) {
        if (s.size == m) {
            println(s.joinToString(" "))
            return
        }
        for (j in i until n) {
            if (j == i || arr[j] != arr[j - 1]) {
                go(j + 1, s + arr[j])
            }
        }
    }
    go(0, listOf())
}
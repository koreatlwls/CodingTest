package september.september11

private fun main() {
    readLine()
    val A = readLine()!!.split(" ").map { it.toInt() }.toSet()
    val N = readLine()!!.toInt()
    var ans = 0
    for (l in 1..N) {
        for (r in maxOf(N, l + 1)..1000) {
            if (A.all { it !in l..r }) ans += 1
        }
    }
    println(ans)
}
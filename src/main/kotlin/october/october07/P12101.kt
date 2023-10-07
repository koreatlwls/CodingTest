package october.october07

private fun main() {
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val res = ArrayList<String>()

    fun go(now: Int, str: String) {
        if (now == N) {
            res.add(str)
            return
        }
        if (now > N) {
            return
        }

        for (i in 1..3) {
            go(now + i, "$str+$i")
        }
    }

    for (i in 1..3) {
        go(i, "$i")
    }

    println(if (res.size < K) -1 else res[K - 1])
}
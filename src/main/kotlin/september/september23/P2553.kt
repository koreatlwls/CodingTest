package september.september23

private fun main() {
    val n = readln().toInt()
    var result = 1L

    for (i in 1..n) {
        result *= i
        result %= 10000000
        while (result % 10 == 0L) {
            result /= 10
        }
    }

    println(result % 10)
}


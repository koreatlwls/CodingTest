package september.september16

private fun main() {
    repeat(readLine()!!.toInt()) {
        readLine()!!
        val A = readLine()!!.split(" ").map { it.toInt() }.toSet()
        readLine()
        println(readLine()!!.split(" ").map { if (it.toInt() in A) "1" else "0" }.joinToString("\n"))
    }
}
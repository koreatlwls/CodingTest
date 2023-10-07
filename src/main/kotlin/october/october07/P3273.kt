package october.october07

private fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map{ it.toInt() }
    val x = readLine()!!.toInt()
    val f = a.groupBy{ it }.map{ (a, b) -> a to b.size }.toMap()
    println(f.map{ (y, c) ->  c.toLong() * f.getOrElse(x - y) { 0 } }.sum() / 2)
}
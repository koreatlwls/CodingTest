package implementation

val br = System.`in`.bufferedReader()
fun main() = with(System.out.bufferedWriter()){
    val input = br.readLine()!!.replace("XXXX", "AAAA").replace("XX", "BB")
    write("${if ('X' in input) -1 else input}")
    close()
}

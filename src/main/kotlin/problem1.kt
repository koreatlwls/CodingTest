import kotlin.math.min

private fun main() = with(System.`in`.bufferedReader()) {
    var result = Int.MAX_VALUE
    val (n,b,h,w) = readLine().split(" ").map { it.toInt() }
    repeat(h){
        val cost = readLine().toInt()
        val week = readLine().split(" ").map { it.toInt() }
        for(i in 0 until w){
            if(n <= week[i] && b >= cost * n){
                result = min(result, cost * n)
                break
            }
        }
    }

    if(result == Int.MAX_VALUE){
        print("stay home")
    }else{
        print(result)
    }
}
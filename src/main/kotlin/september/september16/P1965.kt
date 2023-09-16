package september.september16

import kotlin.math.max

private fun main() {
    val N = readLine()!!.toInt()
    val box = readLine()!!.split(" ").map { it.toInt() }
    val dp = IntArray(N)

    var count = 0

    for(i in 0 until N){
        dp[i] = 1
        for(j in 0 until i){
            if(box[j] < box[i]){
                dp[i] = max(dp[j]+1, dp[i])
            }
        }

        count = max(count, dp[i])
    }

    println(count)
}
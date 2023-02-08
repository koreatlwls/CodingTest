package class2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m, b) = readLine().split(" ").map { it.toInt() }
    var minTime = Int.MAX_VALUE
    var minTimeHeight = 0
    var sum:Long = 0
    val arr = Array<Array<Int>>(n) { Array<Int>(m) { 0 } }
    // 좌표 값 입력
    for(i in 0 until n){
        val st = StringTokenizer(readLine(), " ")
        for(j in 0 until m){
            arr[i][j] = Integer.parseInt(st.nextToken())
            sum += arr[i][j]
        }
    }
    val average:Long = (sum+b)/(n*m)
    val maxHeight = if (average>256)256 else average.toInt()
    for(targetHeight in 0..maxHeight){
        var time = 0
        for(l in 0 until n){
            for(z in 0 until m){
                if (arr[l][z] > targetHeight){
                    time += (arr[l][z] - targetHeight) * 2
                }else if (arr[l][z] < targetHeight){
                    time += targetHeight-arr[l][z]
                }
            }
        }
        if(minTime >= time){
            minTime = time
            minTimeHeight = targetHeight
        }
    }

    val sb = StringBuilder()
    sb.append("$minTime").append(" $minTimeHeight")
    print(sb)
}

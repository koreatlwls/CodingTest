package nadongbin.greedy

// 큰 수의 법칙

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(readLine(), " ")
    val input = IntArray(n)
    repeat(n) { idx ->
        input[idx] = st.nextToken().toInt()
    }

    input.sort()
    val first = input[n-1]
    val second = input[n-2]

    var answer = 0
    var count = 0

    repeat(m){
        if(count == k){
            answer += second
            count = 0
        }else{
            answer += first
            count++
        }
    }

    println(answer)
}

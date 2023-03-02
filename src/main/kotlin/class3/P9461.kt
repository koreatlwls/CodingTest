package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val arr = LongArray(101)

    arr[1] = 1L
    arr[2] = 1L
    arr[3] = 1L

    for(i in 4 .. 100){
        arr[i] = arr[i-3] + arr[i-2]
    }

    repeat(readLine().toInt()){
        val n = readLine().toInt()

        println(arr[n])
    }
}

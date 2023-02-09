package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
   solution()
}

fun solution(){
    val isBroken = BooleanArray(10)

    val N_str = readLine()!!
    val N = N_str.toInt()
    val M = readLine()!!.toInt()


    //부서진 버튼이 있다면
    if(M > 0)
    {
        val str = readLine()!!

        for(i in str.indices step 2)
            isBroken[str[i] - '0'] = true
    }

    val range = (0..9).filter { i -> !isBroken[i] }
    val range_set = HashSet<Int>(range)
    val max_value = getMaxValue(N, range_set)
    var min = abs(N - 100)

    for(i in (0 .. max_value).filter { i ->
        for(c in i.toString())
        {
            if(!range_set.contains(c-'0'))
                return@filter false
        }
        true
    })
    {
        val str = i.toString()
        min = min(str.length + abs(N - i), min)

        if(i == N)
            break
    }

    print(min)
}

fun getMaxValue(N : Int, range_set : HashSet<Int>) : Int
{
    for(i in N .. 1000000)
    {
        var isFinish = true
        for(c in i.toString())
        {
            if(!range_set.contains(c-'0'))
            {
                isFinish = false
                break
            }
        }

        if(isFinish)
            return i
    }
    return 1000000
}

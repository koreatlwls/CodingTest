import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private var n = 0
private var m = 0
private val sb = StringBuilder()
private lateinit var arr: Array<Int>
private lateinit var visited: Array<Boolean>

//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val st = StringTokenizer(readLine())
//
//    n = st.nextToken().toInt()
//    m = st.nextToken().toInt()
//    arr = Array(m) { 0 }
//    visited = Array(n + 1) { false }
//
//    dfs(0)
//
//    println(sb)
//}

private fun dfs(depth : Int){
    if(depth == m){
        arr.forEach {
            sb.append(it).append(' ')
        }
        sb.append("\n")
        return
    }

    for(i in 1..n){
        if(visited[i])continue

        visited[i] = true
        arr[depth] = i
        dfs(depth+1)
        visited[i] = false
    }
}

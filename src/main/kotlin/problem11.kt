import java.util.LinkedList

private var n = 0
private lateinit var arr : Array<MutableList<Int>>
private lateinit var visited : BooleanArray
private var result = 0

private fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    arr = Array(n+1){ mutableListOf()}
    visited = BooleanArray(n+1)

    val m = readLine().toInt()
    repeat(m){
        val(a,b) = readLine().split(" ").map { it.toInt() }
        arr[a].add(b)
        arr[b].add(a)
    }

    bfs()
    println(result)
}

private fun bfs(){
    val queue = LinkedList<Int>()
    queue.add(1)
    visited[1] = true

    while(queue.isNotEmpty()){
        val node = queue.poll()

        for(i in arr[node]){
            if(!visited[i]){
                visited[i] = true
                queue.add(i)
                result++
            }
        }
    }
}
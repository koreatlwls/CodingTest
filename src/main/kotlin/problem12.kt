import java.util.LinkedList

private var n = 0
private var m = 0
private var v = 0
private lateinit var arr : Array<MutableList<Int>>
private lateinit var visited : BooleanArray
private val bfsResult = mutableListOf<Int>()
private val dfsResult = mutableListOf<Int>()

private fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    v = input[2]

    arr = Array(n+1){ mutableListOf()}
    visited = BooleanArray(n+1)

    repeat(m){
        val(a,b) = readLine().split(" ").map { it.toInt() }
        arr[a].add(b)
        arr[b].add(a)
    }

    repeat(n+1){
        arr[it] = arr[it].sorted().toMutableList()
    }

    bfs()
    visited = BooleanArray(n+1)
    dfs(v)

    println(dfsResult.joinToString(" "))
    println(bfsResult.joinToString(" "))
}

private fun bfs(){
    val queue = LinkedList<Int>()
    queue.add(v)
    visited[v] = true
    bfsResult.add(v)

    while(queue.isNotEmpty()){
        val node = queue.poll()

        for(i in arr[node]){
            if(!visited[i]){
                visited[i] = true
                queue.add(i)
                bfsResult.add(i)
            }
        }
    }
}

private fun dfs(start : Int){
    dfsResult.add(start)
    visited[start] = true

    for(i in arr[start]){
        if(!visited[i]){
            visited[i] = true
            dfs(i)
        }
    }
}
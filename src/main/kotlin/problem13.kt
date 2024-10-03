import java.util.LinkedList

private var n = 0
private var m = 0
private lateinit var arr : Array<IntArray>
private lateinit var visited : Array<BooleanArray>
private val dr = intArrayOf(0,0,-1,1)
private val dc = intArrayOf(-1,1,0,0)

private fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]

    arr = Array(n){IntArray(m)}
    visited=  Array(n){ BooleanArray(m) }

    repeat(n){
        arr[it] = readLine().map { it -'0' }.toIntArray()
    }

    println(bfs())
}

private fun bfs() : Int{
    val queue = LinkedList<Triple<Int,Int, Int>>()
    visited[0][0] = true
    queue.add(Triple(0,0,1))

    while(queue.isNotEmpty()){
        val node = queue.poll()

        if(node.first == n-1 && node.second == m-1){
            return node.third
        }

        for(i in 0 until 4){
            val nextRow = node.first + dr[i]
            val nextCol = node.second + dc[i]

            if(nextRow in 0 until n && nextCol in 0 until m && !visited[nextRow][nextCol] && arr[nextRow][nextCol] == 1){
                visited[nextRow][nextCol] = true
                queue.add(Triple(nextRow, nextCol, node.third + 1))
            }
        }
    }
    return -1
}
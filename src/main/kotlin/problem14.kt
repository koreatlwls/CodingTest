import java.util.LinkedList

private fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t){
        val (a,b) = readLine().split(" ").map { it.toInt() }
        println(bfs(a,b))
    }
}

private fun bfs(start : Int, target:Int) : String{
    val visited = BooleanArray(10001)
    val queue = LinkedList<Pair<Int, String>>()
    queue.add(Pair(start, ""))
    visited[start] = true

    while(queue.isNotEmpty()){
        val node = queue.poll()

        if(node.first == target){
            return node.second
        }

        val nextD = d(node.first)
        if(!visited[nextD]){
            visited[nextD]= true
            queue.add(Pair(nextD, node.second + "D"))
        }

        val nextS = s(node.first)
        if(!visited[nextS]){
            visited[nextS]= true
            queue.add(Pair(nextS, node.second + "S"))
        }

        val nextL = l(node.first)
        if(!visited[nextL]){
            visited[nextL]= true
            queue.add(Pair(nextL, node.second + "L"))
        }

        val nextR = r(node.first)
        if(!visited[nextR]){
            visited[nextR]= true
            queue.add(Pair(nextR, node.second + "R"))
        }
    }

    return ""
}

private fun d(input : Int) : Int {
    return input * 2 % 10000
}

private fun s(input : Int) : Int {
    return if(input == 0) 9999 else input -1
}

private fun l(input : Int) : Int{
    return (input % 1000) * 10 + (input / 1000)
}

private fun r(input : Int) : Int{
    return (input % 10 * 1000) + (input /10)
}
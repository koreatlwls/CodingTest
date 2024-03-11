package programmers

class Solution26 {

    val INF = Int.MAX_VALUE

    var maxY=-INF
    var maxX=-INF
    var minY=INF
    var minX=INF

    fun solution(line: Array<IntArray>): Array<String> {
        val xyArr = ArrayList<Pair<Int,Int>>()

        for(i in line.indices){
            for(j in i+1 until line.size){
                val (A,B,E) = line[i].map{it.toLong()}
                val (C,D,F) = line[j].map{it.toLong()}

                val adbc = A*D-B*C
                val bfed = B*F-E*D
                val ecaf = E*C-A*F

                if(adbc == 0L) continue

                if(bfed%adbc!=0L || ecaf%adbc!=0L) continue

                val x = (bfed/adbc).toInt()
                val y = (ecaf/adbc).toInt()

                xyArr.add(Pair(x,y))

                maxX = maxX.coerceAtLeast(x)
                minX = minX.coerceAtMost(x)
                maxY = maxY.coerceAtLeast(y)
                minY = minY.coerceAtMost(y)

            }
        }

        val graph = Array(maxY-minY+1){CharArray(maxX-minX+1){'.'}}

        for(xy in xyArr){
            val r = maxY-xy.second
            val c = xy.first-minX
            graph[r][c]='*'
        }

        val answer = Array(graph.size){String(graph[it])}

        return answer
    }
}
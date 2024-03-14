package programmers

class Solution30{

    private val dr = arrayOf(0, 0, 1, -1)
    private val dc = arrayOf(1, -1, 0, 0)

    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var answer = IntArray(2)

        var startRow = 0
        var startCol = 0

        park.forEachIndexed { row, str ->
            val col = str.indexOfFirst { it == 'S'}
            if(col != -1){
                startRow = row
                startCol = col
            }
        }

        routes.forEach {
            var nextRow = startRow
            var nextCol = startCol

            val split = it.split(" ")
            val direction = when(split[0]){
                "E" -> 0
                "W" -> 1
                "S" -> 2
                else -> 3
            }

            var check = true
            repeat(split[1].toInt()){
                nextRow += dr[direction]
                nextCol += dc[direction]

                if(nextRow !in park.indices || nextCol !in 0 until park[0].length || park[nextRow][nextCol] == 'X'){
                    check = false
                }
            }

            if(check){
                startRow = nextRow
                startCol = nextCol
            }
        }

        answer[0] = startRow
        answer[1] = startCol
        return answer
    }
}
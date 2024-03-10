package programmers

class Solution20 {

    val answer = IntArray(2)

    fun solution(arr: Array<IntArray>): IntArray {
        dfs(arr, 0, 0, arr.size)
        return answer
    }

    fun dfs(arr: Array<IntArray>, row: Int, col: Int, size: Int) {
        val check = zip(arr, row, col, size)
        if (check != -1) {
            answer[check]++
            return
        }

        dfs(arr, row, col, size / 2)
        dfs(arr, row + size / 2, col, size / 2)
        dfs(arr, row, col + size / 2, size / 2)
        dfs(arr, row + size / 2, col + size / 2, size / 2)
    }

    fun zip(arr: Array<IntArray>, row: Int, col: Int, size: Int): Int {
        val check = arr[row][col]

        for (i in row until row + size) {
            for (j in col until col + size) {
                if (check != arr[i][j]) {
                    return -1
                }
            }
        }

        return check
    }
}
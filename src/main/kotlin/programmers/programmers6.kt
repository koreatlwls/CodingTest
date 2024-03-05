package programmers

class Solution6 {

    lateinit var arr: IntArray
    val map = mutableMapOf<Int, Int>()

    fun solution(elements: IntArray): Int {
        arr = elements + elements

        repeat(elements.size) { ccnt ->
            repeat(elements.size) { idx ->
                dfs(idx, arr[idx], 1, ccnt + 1)
            }
        }
        return map.size
    }

    fun dfs(idx: Int, sum: Int, cnt: Int, ccnt: Int) {
        if (cnt == ccnt) {
            map[sum] = 1
            return
        }

        dfs(idx + 1, sum + arr[idx + 1], cnt + 1, ccnt)
    }
}
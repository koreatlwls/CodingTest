package programmers

import kotlin.math.*

// 바탕화면 정리

private fun solution(wallpaper: Array<String>): IntArray {
    var minRow = Int.MAX_VALUE
    var minCol = Int.MAX_VALUE
    var maxRow = Int.MIN_VALUE
    var maxCol = Int.MIN_VALUE

    val length = wallpaper[0].length
    for (i in wallpaper.indices) {
        for (j in 0 until length) {
            if (wallpaper[i].get(j) == '#') {
                minRow = min(minRow, i)
                minCol = min(minCol, j)
                maxRow = max(maxRow, i)
                maxCol = max(maxCol, j)
            }
        }
    }

    return intArrayOf(minRow, minCol, maxRow + 1, maxCol + 1)
}

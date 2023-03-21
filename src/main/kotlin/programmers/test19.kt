package programmers

import kotlin.math.pow

// 당구 연습

private fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
    val answer = IntArray(balls.size)
    val arr = IntArray(4)
    for (i in balls.indices) {

        if (startY == balls[i][1]) {
            val minY = (n - startY).coerceAtMost(startY)

            arr[0] = (balls[i][0] - startX).toDouble().pow(2.0).toInt() + (minY * 2).toDouble().pow(2.0)
                .toInt()

            if (startX < balls[i][0]) {
                arr[1] = (startX + balls[i][0]).toDouble().pow(2.0).toInt()
            } else {
                arr[1] = (m - startX + m - balls[i][0]).toDouble().pow(2.0).toInt()
            }
            answer[i] = arr[0].coerceAtMost(arr[1])
        } else if (startX == balls[i][0]) {

            val minX = (m - startX).coerceAtMost(startX)
            arr[0] = (minX * 2).toDouble().pow(2.0).toInt() + (balls[i][1] - startY).toDouble().pow(2.0)
                .toInt()

            if (startY < balls[i][1]) {
                arr[1] = (startY + balls[i][1]).toDouble().pow(2.0).toInt()
            } else {
                arr[1] = (n - startY + n - balls[i][1]).toDouble().pow(2.0).toInt()
            }
            answer[i] = arr[0].coerceAtMost(arr[1])
        } else {

            arr[0] = (m + (m - startX) - balls[i][0]).toDouble().pow(2.0)
                .toInt() + (balls[i][1] - startY).toDouble().pow(2.0).toInt()

            arr[1] = (startX + balls[i][0]).toDouble().pow(2.0)
                .toInt() + (balls[i][1] - startY).toDouble().pow(2.0).toInt()

            arr[2] = (n + (n - startY) - balls[i][1]).toDouble().pow(2.0)
                .toInt() + (balls[i][0] - startX).toDouble().pow(2.0).toInt()

            arr[3] = (startY + balls[i][1]).toDouble().pow(2.0)
                .toInt() + (balls[i][0] - startX).toDouble().pow(2.0).toInt()

            var min = arr[0]
            for (j in 1..3) {
                if (min > arr[j]) {
                    min = arr[j]
                }
            }
            answer[i] = min
        }
    }
    return answer
}

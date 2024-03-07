package programmers

class Solution16 {
    // 상 우 하 좌 이동시길 좌표
    val dx1 = intArrayOf(0, 1, 0, -1)
    val dy1 = intArrayOf(-1, 0, 1, 0)

    // 오른쪽 위, 오른쪽 아래, 왼쪽 아래, 왼쪽 위 이동시킬 좌표
    val dx2 = intArrayOf(1, 1, -1, -1)
    val dy2 = intArrayOf(-1, 1, 1, -1)

    fun solution(places: Array<Array<String>>) = places.map { checkPlace(it) }.toIntArray()

    // 입력받은 x, y가 배열의 범위안에 있는지 판별
    fun isRange(x: Int, y: Int) = x in 0..4 && y in 0..4

    // 현재 방이 거리두기를 지키면 1 아니면 0을 반환
    fun checkPlace(p: Array<String>): Int {
        for (i in 0..4) {
            for (j in 0..4) {
                // 현재 지정한 위치에 사람이 있을 경우
                if (p[i][j] == 'P') {
                    for (k in 0..3) {
                        var x = j + dx1[k]
                        var y = i + dy1[k]
                        // 범위안에 계산한 상하좌우 x, y값이 있을 경우
                        if (isRange(x, y)) {
                            // x, y에 사람이 있으면 바로 붙어있음으로 0리턴
                            if (p[y][x] == 'P') return 0;

                            val x1 = x + dx1[k];
                            val y1 = y + dy1[k];
                            // 중간에 칸막이가 없는데 다음 칸에 사람이 있으면 0리턴
                            if (isRange(x1, y1) && p[y1][x1] == 'P' && p[y][x] == 'O') return 0
                        }
                        x = j + dx2[k];
                        y = i + dy2[k];
                        // 범위안에 계산한 대각선 x, y값이 있으면서 맨하튼 거리를 지키지 못한 경우 0리턴
                        if (isRange(x, y) && p[y][x] == 'P' && (p[i][x] == 'O' || p[y][j] == 'O')) return 0
                    }
                }
            }
        }
        return 1    // 위의 케이스를 모두 통과했다면 거리두기를 지켰음으로 1리턴
    }
}
package class3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var water: Array<IntArray>
private val dy = arrayOf(-1, 0, 1, 0)
private val dx = arrayOf(0, 1, 0, -1)

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    water = Array(n) { IntArray(n) }
    var babyShark = Shark(0, 0, 0, 0, 0)

    for (i in 0 until n) {
        val st = StringTokenizer(readLine(), " ")
        for (j in 0 until n) {
            water[i][j] = st.nextToken().toInt()
            if (water[i][j] == 9) {
                babyShark = Shark(j, i, 0, 2, 0)
                water[i][j] = 0
            }
        }
    }

    var answer = 0
    while (true) {
        val eatFirst = searchFish(babyShark)
        if (eatFirst.dst == -1) break

        babyShark.also {
            it.x = eatFirst.dot.x
            it.y = eatFirst.dot.y
            if (it.exp + 1 == it.lev) {
                it.lev++
                it.exp = 0
            } else {
                it.exp++
            }
            water[it.y][it.x] = 0
        }

        answer += eatFirst.dst
    }

    println(answer)
}

private fun searchFish(babyShark: Shark): FishEatable {
    val isVisited = Array(water.size) { BooleanArray(water[0].size) }
    val eatable = PriorityQueue<FishEatable>()
    val queue: Queue<Shark> = LinkedList()

    isVisited[babyShark.y][babyShark.x] = true
    queue.add(babyShark)

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        if (water[cur.y][cur.x] in 1 until cur.lev) {
            eatable.offer(FishEatable(cur.cnt, cur))
            continue
        }

        for (i in 0 until 4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx in water.indices && ny in water.indices && !isVisited[ny][nx] && water[ny][nx] <= cur.lev) {
                isVisited[ny][nx] = true
                queue.add(Shark(nx, ny, cur.exp, cur.lev, cur.cnt + 1))
            }
        }
    }

    return if (eatable.isNotEmpty()) eatable.peek() else FishEatable(-1, babyShark)
}

private data class Shark(
    var x: Int,
    var y: Int,
    var exp: Int,
    var lev: Int,
    var cnt: Int
)

private data class FishEatable(
    val dst: Int,
    val dot: Shark
) : Comparable<FishEatable> {
    override fun compareTo(other: FishEatable): Int {
        if (this.dst == other.dst) {
            if (this.dot.y == other.dot.y) {
                return this.dot.x - other.dot.x
            }
            return this.dot.y - other.dot.y
        }
        return this.dst - other.dst
    }
}

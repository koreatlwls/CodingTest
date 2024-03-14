package programmers

class Solution29 {
    fun solution(plans: Array<Array<String>>): Array<String> {
        val timeline = mutableListOf<Pair<String, Int>>()
        val plans2 = plans.map {
            Triple(
                it[0],
                it[1].split(":").fold(0){acc, s -> acc * 60 + s.toInt() },
                it[2].toInt()
            )
        }.sortedBy { it.second }

        for((name, start, playtime) in plans2){
            timeline.forEachIndexed { index, each ->
                if(each.second > start) {
                    timeline[index] = Pair(each.first, each.second + playtime)
                }
            }
            timeline.add(Pair(name, start + playtime))
        }

        return timeline.sortedBy {it.second }.map{it.first}.toTypedArray()
    }
}
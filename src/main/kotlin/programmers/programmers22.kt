package programmers

class Solution22 {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var answer = Array(players.size){""}

        val rankingMap = mutableMapOf<String, Int>()
        val nameMap = mutableMapOf<Int, String>()

        players.forEachIndexed { index, name ->
            rankingMap[name] = index
            nameMap[index] = name
        }

        callings.forEach {
            val nowRanking = rankingMap[it]!!

            val prevName = nameMap[nowRanking - 1]!!

            nameMap[nowRanking] = prevName
            nameMap[nowRanking -1] = it
            rankingMap[it] = nowRanking - 1
            rankingMap[prevName] = nowRanking
        }

        nameMap.forEach {
            answer[it.key] = it.value
        }

        return answer
    }
}
import kotlin.math.ceil

private class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val defaultTime = fees[0]
        val defaultMoney = fees[1]
        val overTime = fees[2]
        val overMoney = fees[3]

        val inCarMap = mutableMapOf<String, String>()
        val timeCarMap = mutableMapOf<String, Int>()

        for (i in records.indices) {
            val splitRecords = records[i].split(" ")

            if (splitRecords[2] == "IN") {
                inCarMap[splitRecords[1]] = splitRecords[0]
            } else {
                val carNumber = splitRecords[1]
                val time = diffTime(inCarMap[carNumber]!!, splitRecords[0])

                if (timeCarMap.containsKey(carNumber)) {
                    timeCarMap[carNumber] = timeCarMap[carNumber]!! + time
                } else {
                    timeCarMap[carNumber] = time
                }

                inCarMap[carNumber] = ""
            }
        }

        inCarMap.forEach {
            if (it.value != "") {
                val time = diffTime(it.value, "23:59")

                if (timeCarMap.containsKey(it.key)) {
                    timeCarMap[it.key] = timeCarMap[it.key]!! + time
                } else {
                    timeCarMap[it.key] = time
                }
            }
        }

        return solve(timeCarMap, defaultTime, defaultMoney, overTime, overMoney)
    }

    fun diffTime(prevTime: String, nextTime: String): Int {
        val splitPrevTime = prevTime.split(":")
        val splitNextTime = nextTime.split(":")

        val prevTotalTime = splitPrevTime[0].toInt() * 60 + splitPrevTime[1].toInt()
        val nextTotalTime = splitNextTime[0].toInt() * 60 + splitNextTime[1].toInt()

        return nextTotalTime - prevTotalTime
    }

    fun solve(map: Map<String, Int>, defaultTime: Int, defaultMoney: Int, overTime: Int, overMoney: Int): IntArray {
        val result = mutableListOf<Pair<Int, Int>>()

        map.forEach {
            val carNumber = it.key.toInt()
            var money = 0

            if (it.value <= defaultTime) {
                money += defaultMoney
            } else {
                money += defaultMoney

                val over = it.value - defaultTime
                money += (ceil(over / overTime.toFloat()).toInt() * overMoney)
            }

            result.add(Pair(carNumber, money))
        }

        val sortedResult = result.sortedBy { it.first }
        val moneyResult = sortedResult.map { it.second }

        return moneyResult.toIntArray()
    }
}
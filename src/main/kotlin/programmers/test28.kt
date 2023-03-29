package programmers

// 문자열 나누기

private fun solution(s: String): Int {
    var answer: Int = 0
    var str = s
    while (str.isNotEmpty()) {
        var sCnt = 1
        var oCnt = 0
        for (i in 1 until str.length) {
            if (str.elementAt(0) == str.elementAt(i)) sCnt++ else oCnt++
            if (sCnt == oCnt) break
        }
        str = str.substring(sCnt + oCnt)
        answer++
    }
    return answer
}
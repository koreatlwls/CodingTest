package programmers

// 시소 짝꿍

private fun solution(weights: IntArray): Long {
    val hm = mutableMapOf<Double, Int>()
    var ret = 0L
    weights.sort()
    for (weight in weights) {
        ret += helper(weight, hm)
    }
    return ret
}

private fun helper(w: Int, hm: MutableMap<Double, Int>): Long {
    var ret = 0L
    val d1 = w.toDouble()
    val d2 = (w * 2.0) / 3.0
    val d3 = (w * 1.0) / 2.0
    val d4 = (w * 3.0) / 4.0
    if (hm.containsKey(d1)) ret += hm[d1]!!
    if (hm.containsKey(d2)) ret += hm[d2]!!
    if (hm.containsKey(d3)) ret += hm[d3]!!
    if (hm.containsKey(d4)) ret += hm[d4]!!
    hm[w.toDouble()] = hm.getOrDefault(w.toDouble(), 0) + 1
    return ret
}

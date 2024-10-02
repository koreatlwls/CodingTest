private val bw = System.`out`.bufferedWriter()
private val st = HashSet<String>()
private var N = 0;
private var M = 0
private lateinit var arr: List<Int>
private lateinit var used: BooleanArray
private fun sol(str: String) {
    if (str.filter { it == '#' }.length == M) {
        val ret = str.replace('#', ' ')
        if (!st.contains(ret)) {
            st.add(ret)
            bw.write(ret + '\n')
        }
        return;
    }
    for (i in 0 until N) {
        if (!used[i]) {
            used[i] = true
            sol(str + arr[i].toString() + "#")
            used[i] = false;
        }
    }
}

private fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(' ').map { it.toInt() }
    N = input[0]; M = input[1]
    arr = readLine().split(' ').map { it.toInt() }
    used = BooleanArray(N)
    arr = arr.sorted()
    sol("")
    bw.close()
}
package september.september23

private fun main() {
    fun dfs(alphabet: IntArray, length: Int, str: String) {
        if (str.length == length) {
            println(str)
            return
        }
        for (i in alphabet.indices) {
            if (alphabet[i] > 0) {
                alphabet[i]--
                dfs(alphabet, length, str + (i + 'a'.code).toChar())
                alphabet[i]++
            }
        }
    }

    repeat(readln().toInt()) {
        val input = readln()
        val alphabet = IntArray('z' - 'a' + 1)
        input.forEach { alphabet[it - 'a']++ }
        dfs(alphabet, input.length, "")
    }
}
package programmers

import kotlin.math.*

class Solution32 {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer = IntArray(targets.size)

        val alphabet = IntArray(26) { 1000 }
        keymap.forEach { str ->
            str.forEachIndexed { index, ch ->
                alphabet[ch - 'A'] = min(alphabet[ch - 'A'], index + 1)
            }
        }

        targets.forEachIndexed { index, target ->
            var count = 0
            target.forEach {
                count += alphabet[it - 'A']
            }

            answer[index] = if (count >= 1000) -1 else count
        }

        return answer
    }
}
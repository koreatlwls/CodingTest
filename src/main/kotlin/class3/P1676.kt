package class3

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var N = readLine().toInt()
    var count = 0

    while (N >= 5) {
        count += N / 5
        N /= 5
    }
    print(count)
}

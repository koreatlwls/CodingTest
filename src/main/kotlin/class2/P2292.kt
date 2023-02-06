package class2

import java.io.BufferedReader
import java.io.InputStreamReader

private fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val destination = readLine().toInt()
    var numberOfShell = 1
    var roomNumbers = 1

    if(destination == 1){
        println(1)
    }else{
        while(roomNumbers < destination){
            roomNumbers += (numberOfShell * 6)
            numberOfShell ++
        }
        println(numberOfShell)
    }
}

package programmers

import kotlin.math.*

class Solution31 {

    var answer = Int.MAX_VALUE

    fun solution(picks: IntArray, minerals: Array<String>): Int {
        if(picks[0] > 0){
            val newPick = picks.clone()
            newPick[0]--
            dfs(newPick, 0, 1, minerals, 1, getPirodo(0, minerals[0]))
        }
        if(picks[1] > 0){
            val newPick = picks.clone()
            newPick[1]--
            dfs(newPick, 1, 1, minerals, 1, getPirodo(1, minerals[0]))
        }
        if(picks[2] > 0){
            val newPick = picks.clone()
            newPick[2]--
            dfs(newPick, 2, 1, minerals, 1, getPirodo(2, minerals[0]))
        }

        return answer
    }

    fun dfs(picks : IntArray, pick : Int, cnt : Int, minerals : Array<String>, idx : Int, pirodo : Int)  {
        if(minerals.size  == idx || (picks.sum()==0 && cnt == 5)){
            answer = min(answer, pirodo)
            return
        }

        if(pirodo > answer){
            return
        }

        if(cnt == 5){
            if(picks[0] > 0){
                val newPick = picks.clone()
                newPick[0]--
                dfs(newPick, 0, 1, minerals, idx + 1, pirodo + getPirodo(0, minerals[idx]))
            }
            if(picks[1] > 0){
                val newPick = picks.clone()
                newPick[1]--
                dfs(newPick, 1, 1, minerals, idx + 1, pirodo + getPirodo(1, minerals[idx]))
            }
            if(picks[2] > 0){
                val newPick = picks.clone()
                newPick[2]--
                dfs(newPick, 2, 1, minerals, idx + 1, pirodo + getPirodo(2, minerals[idx]))
            }
        }else{
            dfs(picks, pick, cnt + 1, minerals, idx + 1, pirodo + getPirodo(pick, minerals[idx]))
        }
    }

    fun getPirodo(pick : Int, mineral : String) : Int {
        if(pick == 0) return 1
        else if(pick == 1) {
            if(mineral == "diamond") return 5
            else return 1
        }
        else {
            return when(mineral) {
                "diamond" -> 25
                "iron" -> 5
                else -> 1
            }
        }
    }
}
package september.september23

private fun main(){
    val (n,k) = readLine()!!.split(" ").map { it.toInt() }
    val people = mutableListOf<Int>().also { it.addAll(1..n) }
    val result = mutableListOf<Int>()
    var i = 0
    while(people.size > 1){
        i = (i + k-1) % people.size
        result.add(people.removeAt(i))
    }
    result.add(people[0])
    print("<${result.joinToString(", ")}>")
}
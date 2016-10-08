object Solution {

    def main(args: Array[String]) {
        val N = readLine.toInt
        var sum = BigInt("0")
        for (i <- 1 to N) {
            val n_string = readLine()
            val n_bigint = BigInt(n_string)
            sum += n_bigint
        }
        println (sum.toString.slice(0,10))
    }
}

object Solution {

    def main(args: Array[String]) {
       val t = readLine.toInt
       for (i <- 1 to t) {
           val n = readLine.toInt
           println(BigInt(2).pow(n).toString.map(_.toInt - 48).reduceLeft(_ + _))
       }
    }
}

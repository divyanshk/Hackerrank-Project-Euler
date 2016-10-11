object Solution {
    val Array(n, m) = Array(500, 500)
    val bigNumber = math.pow(10,9).toInt + 7
    val dp = Array.ofDim[Long](n+1, m+1)
      
    def fillDP = {
        dp(0)(0) = 0
        for (i <- 1 to m) {
            dp(0)(i) = 1
        }
        for (j <- 1 to n) {
            dp(j)(0) = 1
        }
        for (i <- 1 to n; j <- 1 to m) {
            dp(i)(j) = (dp(i-1)(j) + dp(i)(j-1)) % bigNumber
        }
    }    
        
    def main(args: Array[String]) {
       fillDP
        val t = readLine.toInt
        for (i <- 1 to t) {
            val Array(r,c) = readLine().split(" ").map(_.toInt)
            println(dp(r)(c))    
        }       
    }
}

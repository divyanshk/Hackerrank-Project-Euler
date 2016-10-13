import scala.collection.mutable.MutableList
    
object Solution {
    
    def main(args: Array[String]) {
    
        val t = readLine.toInt
        
            for (i <- 1 to t) {
            
                val n = readLine.toInt
                val dp = Array.ofDim[Int](n, n)
                var triangle = MutableList.empty[List[Int]]
                
                for (k <- 1 to n) {

                    val row = readLine.split(" ").map(_.toInt).toList
                    triangle += row

                }
                
                dp(0)(0) = triangle(0)(0)
                
                for (r <- 0 until n-1; c <- 0 until triangle(r).length) {
                    
                    dp(r+1)(c+1) = math.max(dp(r)(c) + triangle(r+1)(c+1), dp(r+1)(c+1))
                    dp(r+1)(c) = math.max(dp(r)(c) + triangle(r+1)(c), dp(r+1)(c))
                
                }
            
                println(dp(n-1).max)
                    
        }
    }
}

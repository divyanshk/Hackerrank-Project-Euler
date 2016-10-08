object Solution {
    val bound = math.pow(10,3).toInt + 1
    val array = Array.fill(bound + 1)(0)
        
    def numOfDivisors(n: Long): Int = {
        val num = if ( n % 2 == 0 ) n/2 else n
        var p = 1l
        var count = 0
        while (p * p < num) {
            if (num % p == 0) count += 1
            p +=  1
        }
        if (p * p == num) 2 * count + 1 else 2 * count
    }
    
    def fillArray {
        var iterateIndex = 1
        array(iterateIndex) = 1
        var n = 1
        var leftFactors, rightFactors = 1
        while (iterateIndex <= bound) {
          leftFactors = rightFactors
          rightFactors = numOfDivisors(n + 1)
          val nFactors = leftFactors * rightFactors
          if (nFactors > iterateIndex) {
            for (i <- iterateIndex + 1 to math.min(nFactors, bound)) array(i) = n
            iterateIndex = nFactors
          }
          n += 1
        }
  }

    def main(args: Array[String]) {
        fillArray
        val t = readLine.toInt
        for (i <- 1 to t) {
            val N = readLine.toInt
            val x = array(N + 1)
            println(1l*x*(x+1)/2)
        }
    }
}

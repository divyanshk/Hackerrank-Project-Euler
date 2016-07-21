Object Solution {
    def sievePrimeGenerator(n: Int): Array[Int] = {
        val nums = Array.fill(n + 1)(true)
        val primes = for (i <- (2 to n).toIterator if nums(i)) yield {
          var j = 2
          while (i * j <= n) {
            nums(i * j) = false
            j += 1
          }
          i
        }
        primes.toArray
    }
    def main(args: Array[String]) {
        val upperBound = math.pow(10, 6).toInt;
        val number = (upperBound).toInt;
        val primes: List[Long] = sievePrimeGenerator(number).toList.map(_.toLong)
        val primesSum: List[Long] = primes.scanLeft(0L)(_+_);
        val test = readLine.toInt;
        for (i <- 1 to test) {
            val n = readLine.toInt;
            println(primesSum(primes.indexOf(primes.find(_ > n).get)));
        }
    }
}

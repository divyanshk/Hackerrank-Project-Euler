import scala.io.Source.stdin
    
object Solution {
    val upperBound = math.pow(10,6).toInt * 5
    val cache = Array.fill(upperBound + 1)(-1)
    val largestIndexer = Array.fill(upperBound + 1)(0)    
         
    def fillCache(num: Long) = {
        cache(1) = 0
        for (i <- 2l to num) {
            var seq = i
            var count = 0
            while (seq != 1 && seq >= i) {
                seq = if (seq % 2 == 0) (seq / 2) else (3 * seq + 1)
                count += 1
            }
            cache(i.toInt) = count + cache(seq.toInt)
            largestIndexer(i.toInt) = if (cache(i.toInt) >= cache(largestIndexer(i.toInt-1))) i.toInt else largestIndexer(i.toInt - 1) 
        }
    }    
    
    def main(args: Array[String]) {
        val testCases = stdin.getLines.toList.map(_.toLong).drop(1)
        fillCache(testCases.max)
        testCases.foreach(p => println(largestIndexer(p.toInt)))
    }
}

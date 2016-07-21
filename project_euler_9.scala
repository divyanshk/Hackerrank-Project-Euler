Object Solution {

    def maxPytho(n: Int): Option[Int] = {
        var max = -1;
        for (a <- 1 until n/2) {
            if (((n-a)*(n-a) - a*a)%(2*(n-a)) == 0) {
                val b = ((n-a)*(n-a) - a*a)/(2*(n-a));  
                if (b>0 && (n-a-b)>0) {
                    max = if (a*b*(n-a-b) > max) a*b*(n-a-b) else max;
                }
            }
        }
        if (max == -1)    return None;
        else return Some(max);
    } 
    
    def main(args: Array[String]) {
        val test = readLine.toInt;
        for (i <- 1 to test) {
            val N = readLine.toInt;
            val max = maxPytho(N);
            if (max.isDefined) { 
                println(max.get);
            }
            else {
                println("-1");
            }
        }
    }
}

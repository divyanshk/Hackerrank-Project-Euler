object Solution {

    def largestProduct(numString: String, k: Int): Int = {
        val n = numString.length - k + 1;
        var (max, prod) = (0, 0);
        for (i <- 0 to n-1) {
            prod = numString.substring(i, i+k).toList.map(_.toInt - '0').foldLeft(1)(_*_);
            max = if (prod > max) prod else max;
        }
        max
    }
    
    def main(args: Array[String]) {
        val test = readLine.toInt;
        for (i <- 1 to test) {
            val Array(n, k) = readLine.split(" ").map(_.toInt);
            val num = readLine();
            println(largestProduct(num, k));
        }
    }
    
}

public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        // Write your code here
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }
        double rst = 1.0;
        while (n != 0) {
            if ((n & 1) == 1) {
                rst *= x;
            }
            x *= x;
            n >>>= 1;
        }
        return rst;
    }
}

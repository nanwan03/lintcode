public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        if (dividend == 0 || divisor == 0) {
            return 0;
        }
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long rst = 0;
        while (a >= b) {
            int shift = 0;
            while ( (b << shift) <= a) {
                shift++;
            }
            rst += (long)1 << (shift - 1);
            a -= b << (shift - 1);
            if (sign * rst >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * rst <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)(sign * rst);
    }
}

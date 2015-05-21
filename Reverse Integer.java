public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        if (n == 0) {
            return n;
        }
        int rst = 0;
        while (n != 0) {
            if (Math.abs(rst) > 214748364) {
                return 0;
            }
            rst = rst * 10 + n % 10;
            n /= 10;
        }
        return rst;
    }
}

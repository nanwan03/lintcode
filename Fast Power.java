class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int n, int b) {
        // write your code here
        if (n == 0) {
            return 1 % b;
        }
        if (n == 1) {
            return a % b;
        }
        boolean isNeg = false;
        if (n < 0) {
            isNeg = true;
            n = -n;
        }
        int k = n / 2;
        int l = n - k * 2;
        long t1 = (long)(fastPower(a, k, b) % b);
        long t2 = (long)(fastPower(a, l, b) % b);
        if (isNeg) {
            return (int)(((long)1 / t1 * t1 * t2) % b);
        } else {
            long rst = (long)(((t1 * t1) % b) * t2 % b);
            return (int)rst;
        }
    }
};

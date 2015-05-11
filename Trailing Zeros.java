class Solution {
    //param n : description of n
    //return: description of return
    public long trailingZeros(long n) {
        long rst = 0;
        while (n != 0) {
            rst += n / 5;
            n = n / 5;
        }
        return rst;
    }
};


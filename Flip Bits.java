class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int xor = a ^ b;
        int rst = 0;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                rst++;
            }
            xor >>>= 1;
        }
        return rst;
    }
};


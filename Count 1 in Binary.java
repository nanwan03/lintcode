public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        // write your code here
        if (num == 0) {
            return 0;
        }
        int rst = 0;
        while (num != 0) {
            rst += (num & 1);
            num >>>= 1;
        }
        return rst;
    }
};

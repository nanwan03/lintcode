public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        long rst = 1;
        for (int i = 0; i < A.length; ++i) {
            long num = 0;
            for (int j = i + 1; j < A.length; ++j) {
                if (A[j] < A[i]) {
                    num++;
                }
            }
            rst += num * getFactorial(A.length - i - 1);
        }
        return rst;
    }
    private static long getFactorial(int i) {
        if (i == 0 || i == 1) {
            return 1;
        }
        return ((long)i) * getFactorial(i - 1);
    }
}

public class Solution {
    /*
     * @param A: an integer array
     * @param V: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; ++i) {
            for (int j = A[i]; j <= m; ++j) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);   
            }
        }
        return dp[m];
    }
}
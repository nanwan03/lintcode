public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        long[] dp = new long[]{A[0], Math.max(A[0], A[1]), 0};
        for (int i = 2; i < A.length; ++i) {
            dp[2] = Math.max(dp[0] + A[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[1];
    }
}
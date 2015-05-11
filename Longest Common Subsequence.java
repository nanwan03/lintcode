public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 0; i <= A.length(); i++) {
            for (int j = 0; j <= B.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (A.charAt(i - 1) == B.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;    
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[A.length()][B.length()];
    }
}


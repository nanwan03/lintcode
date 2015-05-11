public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        int longest = 0;
        for (int i = 0; i <= A.length(); i++) {
            for (int j = 0; j <= B.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (A.charAt(i - 1) == B.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        longest = Math.max(longest, dp[i][j]);
                    }
                }
            }
        }
        return longest;
    }
}

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
        int sizeA = A.length();
        int sizeB = B.length();
        int[][] dp = new int[sizeA + 1][sizeB + 1];
        int longest = 0;
        for (int i = 1; i <= sizeA; ++i) {
            for (int j = 1; j <= sizeB; ++j) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    longest = Math.max(longest, dp[i][j]);
                }
            }
        }
        return longest;
    }
}
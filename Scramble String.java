public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // Write your code here
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int size = s1.length();
        boolean[][][] dp = new boolean[size + 1][size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int len = 2; len <= size; len++) {
            for (int i = size - len; i >= 0; i--) {
                for (int j = size - len; j >= 0; j--) {
                    for (int k = 1; k < len && !dp[len][i][j]; k++) {
                        dp[len][i][j] = (dp[k][i][j] && dp[len - k][i + k][j + k]) || (dp[k][i + len - k][j] && dp[len - k][i][j + k]);
                    }
                }
            }
        }
        return dp[size][0][0];
    }
}

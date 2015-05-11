public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i < 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;            
                } else {
                    isPalindrome[i][j] = false;
                }
            }
        }
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
};

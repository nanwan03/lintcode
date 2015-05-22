public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
        	return s;
        }
        int left = 0;
        int right = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int end = 0; end < s.length(); end++) {
        	for (int start = end; start >= 0; start--) {
        		if (s.charAt(start) == s.charAt(end) && 
        				(end - start < 2 || dp[start + 1][end - 1])) {
        			dp[start][end] = true;
        			if (right - left < end - start) {
        				left = start;
        				right = end;
        			}
        		}
        	}
        }
        return s.substring(left, right + 1);
    }
}

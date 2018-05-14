public class Solution {
    /**
     * @param s: a string
     * @return: nothing
     */
    public boolean validPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        return helper(s, 0, s.length() - 1, 0);
    }
    private boolean helper(String s, int left, int right, int del) {
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        if (left >= right) {
            return del <= 1;
        }
        if (del > 0) {
            return false;
        }
        return helper(s, left + 1, right, del + 1) || helper(s, left, right - 1, del + 1);
    }
}
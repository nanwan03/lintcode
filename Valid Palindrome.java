public class Solution {
	/**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        int left = 0;
        left = moveRight(s, left);
        int right = s.length() - 1;
        right = moveLeft(s, right);
        while (left < right) {
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left = moveRight(s, ++left);
            right = moveLeft(s, --right);
        }
        return true;
    }
    private int moveRight(String s, int left) {
        while (left < s.length() && !isValid(s.charAt(left))) {
                left++;
        }
        return left;
    }
    private int moveLeft(String s, int right) {
        while (right >= 0 && !isValid(s.charAt(right))) {
                right--;
        }
        return right;
    }
    private boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
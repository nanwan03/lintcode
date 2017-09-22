public class Solution {
    /*
     * @param : String
     * @return: String
     */
    public String convertPalindrome(String str) {
        // Write your code here
        if (str == null || str.length() == 0 || isValid(str, 0, str.length() - 1)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right) && isValid(str, left, right)) {
                break;
            }
            sb.append(str.charAt(right));
            right--;
        }
        return sb.toString() + str;
    }
    private boolean isValid(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
};
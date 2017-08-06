public class Solution {
    /**
     * @param s a string which consists of lowercase or uppercase letters
     * @return the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // Write your code here
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        int rst = 0;
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if (temp >= 97) {
                lowercase[temp-'a']++;
            } else {
                uppercase[temp-'A']++;
            }
        }
        for (int i = 0; i < 26; i++){
            rst += (lowercase[i] / 2) * 2;
            rst += (uppercase[i] / 2) * 2;
        }
        return rst == s.length() ? rst : rst + 1;
    }
}
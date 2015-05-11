public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        if (str == null || str.length() == 0) {
            return true;
        }
        int[] vec = new int[256 / 32];
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if ((vec[temp / 32] >> (temp % 32) & 1) != 0) {
                return false;
            }
            vec[temp / 32] |= 1 << (temp % 32);
        }
        return true;
    }
}

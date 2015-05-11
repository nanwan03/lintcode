public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    private int getHash(String str) {
        int[] count= new int[256];
        for (char c : str.toCharArray()) {
            count[c]++;
        }
        int hash = 0;
        for (int i : count) {
            hash = hash * 33 + i;
        }
        return hash;
    }
    public boolean anagram(String s, String t) {
        // write your code here
        return getHash(s) == getHash(t);
    }
};

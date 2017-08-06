public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        // Write your code here
        int size = s.length();
        int[] map = new int[256];
        int[] set = new int[256];
        Arrays.fill(map, -1);
        Arrays.fill(set, -1);
        for (int i = 0; i < size; ++i) {
            char sC = s.charAt(i);
            char tC = t.charAt(i);
            if (map[sC] != -1) {
                if (map[sC] != tC) {
                    return false;   
                }
            } else if (set[tC] != -1) {
                return false;
            }
            map[sC] = tC;
            set[tC] = 1;
        }
        return true;
    }
}
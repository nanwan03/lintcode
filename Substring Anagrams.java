public class Solution {
    /**
     * @param s a string
     * @param p a non-empty string
     * @return a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // Write your code here
        List<Integer> rst = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return rst;
        }
        int[] count = new int[256];
        for (char c : p.toCharArray()) {
            count[c]++;
        }
        int left = 0;
        int windowSize = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (--count[s.charAt(i)] >= 0) {
                windowSize++;
            }
            if (windowSize == p.length()) {
                rst.add(left);
            }
            if (i - left + 1 == p.length()) {
                if (++count[s.charAt(left++)] > 0) {
                    windowSize--;
                }
            }
        }
        return rst;
    }
}
public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int unique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
                unique++;
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        if (unique < k) {
            return s.length();
        }
        int curStart = 0;
        int curEnd = 0;
        int windowSize = 1;
        map.clear();
        map.put(s.charAt(0), 1);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
            curEnd++;
            while (map.size() > k) {
                c = s.charAt(curStart);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                	map.remove(c);
                }
                curStart++;
            }
            if (curEnd - curStart + 1 > windowSize) {
                windowSize = curEnd - curStart + 1;
            }
        }
        return windowSize;
    }
}

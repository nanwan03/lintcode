public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // Write your code here
        if (s == null || t == null) {
          return false;
        }
        int l1 = s.length();
        int l2 = t.length();
        if (Math.abs(l1 - l2) >= 2) {
          return false;
        }
        for (int i = 0; i < Math.min(s.length(), t.length()); ++i) {
          if (s.charAt(i) != t.charAt(i)) {
            if (l1 == l2) {
              return s.substring(i + 1).equals(t.substring(i + 1));
            } else if (l1 < l2) {
              return s.substring(i).equals(t.substring(i + 1));
            } else {
              return s.substring(i + 1).equals(t.substring(i));
            }
          }
        }
        return Math.abs(l1 - l2) == 1;
    }
}
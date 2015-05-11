public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        if (s == null) {
            return p == null;
        }
        if (p == null) {
            return s == null;
        }
        int sIndex = 0;
        int pIndex = 0;
        int lastStar = -1;
        int mark = -1;
        while (sIndex < s.length()) {
            if (pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')) {
                sIndex++;
                pIndex++;
            } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                lastStar = ++pIndex;
                mark = sIndex;
            } else if (lastStar != -1) {
                pIndex = lastStar;
                sIndex = ++mark;
            } else {
                return false;
            }
        }
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }
        return pIndex == p.length();
    }
}
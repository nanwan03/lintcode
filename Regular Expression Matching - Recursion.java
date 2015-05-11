public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s.length() == 0) {
            return checkEmpty(p);
        }
        if (p.length() == 0) {
            return false;
        }
        char sC = s.charAt(0);
        char pC = p.charAt(0);
        if (p.length() > 1 && p.charAt(1) == '*') {
            if (compare(sC, pC)) {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            if (compare(sC, pC)) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }
    private boolean checkEmpty(String p) {
        if (p.length() % 2 == 1) {
            return false;
        }
        for (int i = 1; i < p.length(); i = i + 2) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
    private boolean compare(char sC, char pC) {
        return sC == pC || pC == '.';
    }
}

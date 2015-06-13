class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null) {
            return -1;
        }
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = getNext(target);
        while (i < s.length && j < t.length) {
            if (j == -1 || s[i] == t[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == t.length) {
            return i - j;
        }
        return -1;
    }
    private int[] getNext(String target) {
        char[] t = target.toCharArray();
        int[] next = new int[t.length];
        if (t.length == 0) {
            return next;
        }
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < t.length - 1) {
            if (k == -1 || t[j] == t[k]) {
                ++j;
                ++k;
                if (t[j] != t[k]) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }
}

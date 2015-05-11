public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int sign = 1;
        int cur = 0;
        if (str.charAt(0) == '+') {
            cur++;
        }
        if (str.charAt(0) == '-') {
            cur++;
            sign = -1;
        }
        long rst = 0;
        while (cur < str.length()) {
            char c = str.charAt(cur);
            if (Character.isDigit(c)) {
                int digit = (int)(c - '0');
                rst = rst * 10 + (long)(digit);
                if (sign * rst >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sign * rst <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                cur++;
            } else {
                return (int)(sign * rst);
            }
        }
        return (int)(sign * rst);
    }
}

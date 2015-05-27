public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        if (n < 2) {
            return "1";
        }
        String prev = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = prev.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int count = 1;
                while (j + 1 < chars.length && chars[j + 1] == chars[j]) {
                    count++;
                    j++;
                }
                sb.append(count).append(chars[j]);
            }
            prev = sb.toString();
        }
        return prev;
    }
}

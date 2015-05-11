public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        s = s.trim();
        s = reverseStr(s);
        String[] temp = s.split("\\s+");
        String rst = temp.length == 0 ? "" : reverseStr(temp[0]);
        for (int i = 1; i < temp.length; i++) {
            rst = rst + " " + reverseStr(temp[i]);
        }
        return rst;
    }
    private String reverseStr(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }
}


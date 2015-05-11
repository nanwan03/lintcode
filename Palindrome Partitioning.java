public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> rst = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return rst;
        }
        List<String> items = new ArrayList<String>();
        helper(rst, items, s);
        return rst;
    }
    private void helper(List<List<String>> rst, List<String> items, String s) {
        if (s == null || s.length() == 0) {
            rst.add(new ArrayList<String>(items));
            return;
        }
        for (int i= 0; i < s.length();  i++) {
            String str = s.substring(0, i + 1);
            if (isValid(str)) {
                items.add(str);
                helper(rst, items, s.substring(i + 1));
                items.remove(items.size() - 1);
            }
        }
    }
    private boolean isValid(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

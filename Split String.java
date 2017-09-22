public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> rst = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            rst.add(new ArrayList<String>());
            return rst;
        }
        List<String> items = new ArrayList<String>();
        helper(rst, items, s);
        return rst;
    }
    private void helper(List<List<String>> rst, List<String> items, String str) {
        if (str.length() == 0) {
            rst.add(new ArrayList<String>(items));
            return;
        }
        for (int i = 0; i < Math.min(str.length(), 2); ++i) {
            items.add(str.substring(0, i + 1));
            helper(rst, items, str.substring(i + 1));
            items.remove(items.size() - 1);
        }
    }
}
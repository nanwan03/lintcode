public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    private static String[] trans = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> rst = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return rst;
        }
        StringBuilder sb = new StringBuilder();
        helper(rst, sb, digits, 0);
        return rst;
    }
    private void helper(ArrayList<String> rst, StringBuilder sb, String digits, int pos) {
        if (pos == digits.length()) {
            rst.add(sb.toString());
            return;
        }
        String candidates = trans[digits.charAt(pos) - '0'];
        if (candidates.length() == 0) {
            helper(rst, sb, digits, pos + 1);
        } else {
            for (int i = 0; i < candidates.length(); i++) {
                sb.append(candidates.charAt(i));
                helper(rst, sb, digits, pos + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> rst = new ArrayList<String>();
        if (n == 0) {
            return rst;
        }
        String items = "";
        helper(rst, items, n, n);
        return rst;
    }
    private void helper(List<String> rst, String items, int leftNum, int rightNum) {
        if (leftNum == 0 && rightNum == 0) {
            rst.add(items);
            return;
        }
        if (leftNum > 0) {
            helper(rst, items + "(", leftNum - 1, rightNum);
        }
        if (rightNum > leftNum && rightNum > 0) {
            helper(rst, items + ")", leftNum, rightNum - 1);
        }
    }
}

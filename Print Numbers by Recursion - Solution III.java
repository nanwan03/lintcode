public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> rst = new ArrayList<Integer>();
        if (n == 0) {
            return rst;
        }
        helper(rst, n, 0);
        return rst;
    }
    private void helper(List<Integer> rst, int n, int currentLevel) {
        if (currentLevel == n) {
            return;
        }
        if (currentLevel == 0) {
            for (int i = 1; i <= 9; i++) {
                rst.add(i);
            }
        } else {
            int size = rst.size();
            for (int i = 1; i <= 9; i++) {
                rst.add((int)(i * Math.pow(10, currentLevel)));
                for (int j = 0; j < size; j++) {
                    rst.add((int)(rst.get(j) + i * Math.pow(10, currentLevel)));
                }
            }
        }
        helper(rst, n, currentLevel + 1);
    }
}

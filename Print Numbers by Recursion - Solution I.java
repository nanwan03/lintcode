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
        helper(rst, 0, 1, n);
        Collections.sort(rst);
        return rst;
    }
    private void helper(List<Integer> rst, int digit, int curLevel, int n) {
    	if (digit != 0) {
    		rst.add(digit);
    	}
        if (curLevel <= n) {
            for (int i = 0; i <= 9; i++) {
            	int temp = digit * 10 + i;
            	if (temp != 0) {
            		helper(rst, temp, curLevel + 1, n);
            	}
            }
        }
    }
}

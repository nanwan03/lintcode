public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        if (n == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> rst = helper(n);
        return rst;
    }
    private List<Integer> helper(int n) {
    	List<Integer> basic = new ArrayList<Integer>();
    	for (int i = 1; i <= 9; i++) {
			basic.add(i);
		}
    	if (n == 1) {
    		return basic;
    	}
    	List<Integer> prev = helper(n - 1);
    	List<Integer> rst = new ArrayList<Integer>();
    	for (int i : prev) {
    		for (int j = 0; j <= 9; j++) {
    			rst.add(i * 10 + j);
    		}
    	}
    	basic.addAll(rst);
    	return basic;
    }
}

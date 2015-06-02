public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int[][] rst = new int[2][2];
        List<Integer> bound = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
    	    return rst;
        }
        for (int i = 0; i < matrix.length; i++) {
        	int[] temp = new int[matrix[i].length];
        	Arrays.fill(temp, 0);
        	for (int j = i; j < matrix.length; j++) {
        		addMatrix(temp, matrix[j]);
        		bound.clear();
        		if (getMax(bound, temp) == 0) {
        		    rst[0][0] = i;
        		    rst[0][1] = bound.get(0);
        		    rst[1][0] = j;
        		    rst[1][1] = bound.get(1);
        		}
        	}
        }
        return rst;
    }
    private void addMatrix(int[] temp, int[] matrix) {
	  for (int i = 0; i < temp.length; i++) {
		  temp[i] += matrix[i];
	  }
    }
    private int getMax(List<Integer> rst, int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for (int i = 0; i< nums.length; i++) {
            sum += nums[i];
            if (nums[i] == 0) {
                rst.add(i);
                rst.add(i);
                return 0;
            } else if (sum == 0) {
                rst.add(0);
                rst.add(i);
                return 0;
            } else {
                if (!map.containsKey(sum)) {
                    map.put(sum, i + 1);
                } else {
                    rst.add(map.get(sum));
                    rst.add(i);
                    return 0;
                }
            }
        }
        return -1;
    }
}

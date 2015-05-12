class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
    	List<Integer> rst = new ArrayList<Integer>(2);
    	if (A == null || A.length == 0 || A[0].length == 0) {
    		return rst;
    	}
    	int row = A.length;
    	int col = A[0].length;
    	int startX = 1;
    	int startY = col / 2;
    	while (startX >= 0 && startX < row && startY >= 0 && startY < col) {
    	    startX = findPeakRow(A, 0, row - 1, startY);
    	    if (startY - 1 >= 0 && A[startX][startY - 1] > A[startX][startY]) {
    	            startY--;
    	    } else if (startY + 1 < col && A[startX][startY + 1] > A[startX][startY]) {
    	        startY++;
    	    } else {
    	        rst.add(startX);
    	        rst.add(startY);
    	        return rst;
    	    }
    	}
    	return rst;
    }
    public static int findPeakRow(int[][] A, int start, int end, int col) {
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (A[mid - 1][col] < A[mid][col] && A[mid + 1][col] < A[mid][col]) {
    			return mid;
    		} else if (A[mid][col] < A[mid - 1][col]) {
    			end = mid;
    		} else {
    			start = mid;
    		}
    	}
    	return A[start][col] > A[end][col] ? start : end;
    }
}

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
    	int startY = 1;
    	while (startX <= row - 1 && startY <= col - 1) {
    		int cur = A[startX][startY];
    		if (correctPeak(A, startX, startY, row, col)) {
    			rst.add(startX);
    			rst.add(startY);
    			return rst;
    		}
    		if (startX + 1 <= row - 1 && cur < A[startX + 1][startY]) {
    			startX = findPeakRow(A, startX, row - 1, startY);
    		} else if (startY + 1 <= col - 1 && cur < A[startX][startY + 1]) {
    			startY = findPeakCol(A, startY, col - 1, startX);
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
    public static int findPeakCol(int[][] A, int start, int end, int row) {
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (A[row][mid - 1] < A[row][mid] && A[row][mid + 1] < A[row][mid]) {
    			return mid;
    		} else if (A[row][mid] < A[row][mid - 1]) {
    			end = mid; 
    		} else {
    			start = mid;
    		}
    	}
    	return A[row][start] > A[row][end] ? start : end;
    }
    public static boolean correctPeak(int[][] arr, int row, int col, int N, int M) {
        if(row-1>=0 && arr[row-1][col]>arr[row][col])  return false;
        if(row+1<N && arr[row+1][col]>arr[row][col])   return false;
        if(col-1>=0 && arr[row][col-1]>arr[row][col])  return false;
        if(col+1<M && arr[row][col+1]>arr[row][col])   return false;
        return true;
    }
}


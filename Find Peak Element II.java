class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
    	if (A == null || A.length == 0 || A[0].length == 0) {
    		return new ArrayList<Integer>(2);
    	}
    	return helper(A, 0, A.length - 1, 0, A[0].length - 1);
    }
    private List<Integer> helper(int[][] A, int startR, int endR, int startC, int endC) {
        int row = endR - startR + 1;
        int col = endC - startC + 1;
        if (row == 1 && col == 1) {
            List<Integer> rst = new ArrayList<Integer>(2);
            rst.add(startR);
            rst.add(startC);
            return rst;
        }
        int midC = startC + (endC - startC) / 2;
        int midR = startR + (endR - startR) / 2;
        
        int targetR = findPeakRow(A, startR, endR, midC);
        if (midC - 1 >= startC && A[targetR][midC - 1] > A[targetR][midC]) {
            endC = midC - 1;
        } else if (midC + 1 <= endC && A[targetR][midC + 1] > A[targetR][midC]) {
            startC = midC + 1;
        } else {
            List<Integer> rst = new ArrayList<Integer>(2);
            rst.add(targetR);
            rst.add(midC);
            return rst;
        }
        
        int targetC = findPeakCol(A, startC, endC, midR);
        if (midR - 1 >= startR && A[midR - 1][targetC] > A[midR][targetC]) {
            endR = midR - 1;
        } else if (midR + 1 <= endR && A[midR + 1][targetC] > A[midR][targetC]) {
            startR = midR + 1;
        } else {
            List<Integer> rst = new ArrayList<Integer>(2);
            rst.add(midR);
            rst.add(targetC);
            return rst;
        }
        return helper(A, startR, endR, startC, endC);
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
}


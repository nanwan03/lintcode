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
    private List<Integer> helper(int[][] A, int rStart, int rEnd, int cStart, int cEnd) {
        List<Integer> rst = new ArrayList<Integer>(2);
        int row = rEnd - rStart + 1;
        int col = cEnd - cStart + 1;
        if (row == 1 && col == 1) {
            rst.add(rStart);
            rst.add(rEnd);
            return rst;
        }
        int targetR = -1;
        int targetC = -1;
        int max = Integer.MIN_VALUE;
        if (row > col) {
            int midRow = rStart + (rEnd - rStart) / 2;
            for (int i = Math.max(rStart, midRow - 1); i <= Math.min(rEnd, midRow + 1); i++) {
                for (int j = cStart; j <= cEnd; j++) {
                    if (A[i][j] > max) {
                        max = A[i][j];
                        targetR = i;
                        targetC = j;
                    }
                }
            }
            if (targetR == midRow) {
                rst.add(targetR);
                rst.add(targetC);
                return rst;
            } else {
                if (targetR < midRow) {
                    return helper(A, rStart, midRow, cStart, cEnd);
                } else {
                    return helper(A, midRow, rEnd, cStart, cEnd);
                }
            }
        } else {
            int midCol = cStart + (cEnd - cStart) / 2;
            for (int i = rStart; i <= rEnd; i++) {
                for (int j = Math.max(cStart, midCol - 1); j <= Math.min(cEnd, midCol + 1); j++) {
                    if (A[i][j] > max) {
                        max = A[i][j];
                        targetR = i;
                        targetC = j;
                    }
                }
            }
            if (targetC == midCol) {
                rst.add(targetR);
                rst.add(targetC);
                return rst;
            } else {
                if (targetC < midCol) {
                    return helper(A, rStart, rEnd, cStart, midCol);
                } else {
                    return helper(A, rStart, rEnd, midCol, cEnd);
                }
            }
        }
    }
}


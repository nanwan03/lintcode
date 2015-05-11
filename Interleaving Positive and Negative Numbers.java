class Solution {
    /**
     * @param A: An integer array.
     * @return an integer array
     */
    public int[] rerange(int[] A) {
        if (A == null || A.length == 0) {
        	return A;
        }
        int left = 0;
        int right = A.length - 1;
        int cur = 0;
        
        int posNum = 0;
        int negNum = 0;
        while (cur <= right) {
        	if (A[cur] < 0) {
        		swap(A, cur++, left++);
        		negNum++;
        	} else {
        		swap(A, cur, right--);
        		posNum++; 
        	}
        }
        int posIndex = left;
        int negIndex = posNum >= negNum ? 0 : 1;
        while (posIndex < A.length && negIndex < posIndex) {
        	swap(A, posIndex++, negIndex);
        	negIndex += 2;
        }
        return A;
   }
    private void swap(int[] A, int i, int j) {
    	int temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
    }
}

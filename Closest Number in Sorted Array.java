public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
    		return -1;
    	}
    	int left = 0;
    	int right = A.length - 1;
    	while (left + 1 < right) {
    		int mid = left + (right - left) / 2;
    		if (A[mid] == target) {
    			return mid;
    		} else if (A[mid] < target) {
    			left = mid;
    		} else {
    			right = mid;
    		}
    	}
    	if (Math.abs(A[left] - target) < Math.abs(A[right] - target)) {
    		return left;
    	} else {
    		return right;
    	}
    }
}
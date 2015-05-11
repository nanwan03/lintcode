public class Solution {
	/** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[left] < A[mid]) {
                if (A[left] <= target && target <= A[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (A[left] > A[mid]) {
                if (A[mid] <= target && target <= A[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else if (A[mid] != A[right]) {
                left = mid;
            } else {
                left++;
            }
        }
        return A[left] == target || A[right] == target;
    }
}
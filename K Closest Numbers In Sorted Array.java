public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        if(A == null || A.length == 0 || k == 0) {
          return new int[k];
        }
        int index = binarySearch(A, target);
        int[] rst = new int[k];
        int flag = 0;
        if (index == 0) {
        	for (flag = 0; flag < k; ++flag) {
        		rst [flag] = A[flag];
        	}
        	return rst;
        }
        int left = index - 1;
        int right = index;

        while (left >= 0 && right < A.length) {
        	if (Math.abs(A[left] - target) <= Math.abs(A[right] - target)) {
        		rst[flag++] = A[left--];
        	} else {
        		rst[flag++] = A[right++];
        	}
        	if (flag == k) {
        		return rst;
        	}
        }
        
        while (flag < k && left >= 0) {
        	rst[flag++] = A[left--];
        }
        while (flag < k && right < A.length) {
        	rst[flag++] = A[right++];
        }
        return rst;
    }
    private int binarySearch(int[] A, int target) {
    	int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
        	int mid = left + (right - left) / 2;
        	if (A[mid] == target) {
        		return mid;
        	} else if (A[mid] < target) {
        		left = mid + 1;
        	} else {
        		right = mid;
        	}
        }
        if (A[left] == target) {
        	return left;
        } else if (A[right] == target) {
        	return right;
        } else {
        	return A[left] > target ? left : right;
        }
    }
}
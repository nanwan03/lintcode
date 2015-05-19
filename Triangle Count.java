public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
    	if (S == null || S.length == 0) {
    		return 0;
    	}
    	Arrays.sort(S);
    	int rst = 0;
    	for (int i = 0; i < S.length - 2; i++) {
    		for (int j = i + 1; j < S.length - 1; j++) {
    			rst += findUpperBound(S, j + 1, S.length - 1, S[i] + S[j]);
    		}
    	}
    	return rst;
    }
    private static int findUpperBound(int[] S, int left, int right, int target) {
    	if (left > right) {
    		return 0;
    	}
    	int tempLeft = left;
    	int tempRight = right;
    	
    	int leftMost = -1;
    	int rightMost = -1;
    	
    	while (left + 1 < right) {
    		int mid = left + (right - left) / 2;
    		if (S[mid] == target) {
    			right = mid - 1;
    		} else if (S[mid] < target) {
    			left = mid;
    		} else {
    			right = mid - 1;
    		}
    	}
    	if (S[right] < target) {
    		rightMost = right;
    	} else if (S[left] < target){
    		rightMost = left;
    	} else {
    		return 0;
    	}
    	
    	left = tempLeft;
    	right = tempRight;
    	while (left + 1 < right) {
    		int mid = left + (right - left) / 2;
    		if (S[mid] == target) {
    			right = mid - 1;
    		} else if (S[mid] < target) {
    			right = mid;
    		} else {
    			right = mid - 1;
    		}
    	}
    	if (S[left] < target) {
    		leftMost = left;
    	} else {
    		return 0;
    	}
    	return rightMost - leftMost + 1;
    }
}


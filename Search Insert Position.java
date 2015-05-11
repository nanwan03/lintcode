import java.util.ArrayList;

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) {
            return 0;
        }
        int left = 0;
        int right = A.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A.get(mid) == target) {
                return mid;
            } else if (A.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A.get(right) < target) {
            return right + 1;
        } else if (A.get(right) == target || A.get(left) < target) {
            return right;
        } else {
            return left;
        }
    }
}


import java.util.ArrayList;


public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (A == null || A.size() == 0) {
            rst.add(-1);
            rst.add(-1);
            return rst;
        }
        int left = 0;
        int right = A.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A.get(mid) == target) {
                right = mid;
            } else if (A.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A.get(left) == target) {
            rst.add(left);
        } else if (A.get(right) ==target) {
            rst.add(right);
        } else {
            rst.add(-1);
            rst.add(-1);
            return rst;
        }
        
        left = 0;
        right = A.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A.get(mid) == target) {
                left = mid;
            } else if (A.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A.get(right) == target) {
            rst.add(right);
        } else if (A.get(left) == target) {
            rst.add(left);
        } else {
            rst.add(-1);
            rst.add(-1);
            return rst;
        }
        return rst;
    }
}


public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (A == null) {
            return rst;
        }
        Arrays.sort(A);
        for (int i = 0; i < queries.length; i++) {
            rst.add(solve(A, queries[i]));
        }
        return rst;
    }
    private int solve(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                right = mid;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (A[left] >= target) {
            return left;
        } else if (A[right] >= target) {
            return right;
        } else {
            return A.length;
        }
    }
}


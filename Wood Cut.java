public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        int max = L[0];
        for (int i = 1; i < L.length; i++) {
            max = Math.max(L[i], max);
        }
        return cutWood(L, k, max);
    }
    private int cutWood(int[] L, int k, int max) {
        int left = 1;
        int right = max;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int num = getPieces(L, mid);
            if (num < k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        int leftNum = getPieces(L, left);
        int rightNum = getPieces(L, right);
        if (leftNum >= k && rightNum >= k) {
            return Math.max(left, right);
        } else if (leftNum < k && rightNum < k) {
            return 0;
        } else {
            return leftNum >= k ? left : right;
        }
    }
    private int getPieces(int[] L, int weight) {
        int rst = 0;
        for (int i : L) {
            rst += i / weight;
        }
        return rst;
    }
}

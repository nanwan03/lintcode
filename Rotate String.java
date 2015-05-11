public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return A;
        }
        offset = offset % A.length;
        int left = 0;
        int right = A.length - 1;
        reverse(A, left, right - offset);
        reverse(A, right - offset + 1, right);
        reverse(A, left, right);
        return A;
    }
    private void reverse(char[] A, int left, int right) {
        while (left < right) {
            swap(A, left++, right--);
        }
    }
    private void swap(char[] A, int i, int j) {
        char c = A[i];
        A[i] = A[j];
        A[j] = c;
    }
};

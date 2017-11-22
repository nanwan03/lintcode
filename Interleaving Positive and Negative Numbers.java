public class Solution {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        int next = -1;
        int posNum = 0;
        int negNum = 0;
        for (int i : A) {
            if (i < 0) {
                negNum++;
            } else {
                posNum++;
            }
        }
        boolean flag = posNum < negNum;
        for (int i = 0; i < A.length; ++i) {
            if (helper(flag, A, i)) {
                next = Math.max(next, i + 1);
                for(; next < A.length; ++next) {
                    if (A[next] * A[i] < 0) {
                        break;
                    }
                }
                if (next < A.length) {
                    rightShift(A, i++, next++);
                }
            }
        }
    }
    private boolean helper(boolean flag, int[] A, int index) {
        if (!flag) {
            return (index % 2 == 0 && A[index] < 0) || (index % 2 == 1 && A[index] > 0);
        } else {
            return (index % 2 == 1 && A[index] < 0) || (index % 2 == 0 && A[index] > 0);
        }
    }
    private void rightShift(int[] A, int left, int right) {
        int temp = A[right];
        for (int i = right; i > left; --i) {
            A[i] = A[i - 1];
        }
        A[left]  = temp;
    }
}
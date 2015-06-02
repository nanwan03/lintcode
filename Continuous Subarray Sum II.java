public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return rst;
        }
        int total = 0;
        for (int i : A) {
            total += i;
        }
        int sumSoFar = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;
        int first = 0;
        int tempFirst = 0;
        int last = 0;
        for (int i = 0; i < A.length; i++) {
            if(sumSoFar >= 0) {
                sumSoFar = 0;
                tempFirst = i;
            }
            sumSoFar += A[i];
            if (sumSoFar < sum) {
                sum = sumSoFar;
                first = tempFirst;
                last = i;
            }
        }
        int maxSum1 = total - sum;
        if (maxSum1 == 0) {
        	maxSum1 = Integer.MIN_VALUE;
        }
        int first1 = (last + 1) % A.length;
        int last1 = (first - 1 + A.length) % A.length;
        
        sumSoFar = Integer.MIN_VALUE;
        sum = Integer.MIN_VALUE;
        first = 0;
        tempFirst = 0;
        last = 0;
        for (int i = 0; i < A.length; i++) {
            if(sumSoFar <= 0) {
                sumSoFar = 0;
                tempFirst = i;
            }
            sumSoFar += A[i];
            if (sumSoFar > sum) {
                sum = sumSoFar;
                first = tempFirst;
                last = i;
            }
        }
        if (maxSum1 > sum) {
            rst.add(first1);
            rst.add(last1);
        } else {
            rst.add(first);
            rst.add(last);
        }
        return rst;
    }
}

public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] rst = new int[digits.length + 1];
            rst[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                rst[i + 1] = digits[i];
            }
            return rst;
        }
    }
}

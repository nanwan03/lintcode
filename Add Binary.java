public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        if (a == null || b == null) {
            return a;
        }
        if (a.length() == 0 || b.length() == 0) {
            return a.length() == 0 ? b : a;
        }
        if (a.length() < b.length()) {
            String temp = b;
            b = a;
            a = temp;
        }
        int carry = 0;
        int aI = a.length() - 1;
        int bI = b.length() - 1;
        String rst = "";
        while (bI >= 0) {
            int temp = (a.charAt(aI--) - '0') + (b.charAt(bI--) - '0') + carry;
            carry = temp / 2;
            rst = String.valueOf(temp % 2) + rst;
        }
        while (aI >= 0) {
            int temp = a.charAt(aI--) - '0' + carry;
            carry = temp / 2;
            rst = String.valueOf(temp % 2) + rst;
        }
        if (carry == 1) {
            return "1" + rst;
        } else {
            return rst;
        }
    }
}

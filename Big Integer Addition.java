public class Solution {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // Write your code here
        int carry = 0;
        int sum = 0;
        char[] c1 = ((num1.length() > num2.length()) ? num1 : num2).toCharArray();
        char[] c2 = ((num1.length() > num2.length()) ? num2 : num1).toCharArray();
        int l1 = c1.length - 1;
        int l2 = c2.length - 1;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < c2.length; i++){
            sum = add(c1[l1 - i], c2[l2 - i], carry);
            sb.append(sum % 10 + "");
            carry = sum / 10;
        }
        for(int j = c2.length; j < c1.length; j++){
            sum = add(c1[l1 - j], '0', carry);
            sb.append(sum % 10 + "");
            carry = sum / 10;
        }
        if(carry == 1){
            sb.append(carry + "");
        }
        return sb.reverse().toString();
    }
    public int add(char a ,char b ,int c){
        int q = a - '0';
        int p = b - '0';
        return q + p + c;
    }
}
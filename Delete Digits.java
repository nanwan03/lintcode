public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if (A == null || A.length() == 0 || k == 0) {
            return A;
        }
        Stack<Character> stack = new Stack<Character>();
        for (char c : A.toCharArray()) {
            if (stack.isEmpty() || c >= stack.peek()) {
                stack.push(c);
            } else if (c < stack.peek()){
                while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(c);
            }
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        String sb = new String();
        while (!stack.isEmpty()) {
            sb = stack.pop() + sb;
        }
        int start = 0;
        while (start < sb.length() && sb.charAt(start) == '0') {
            start++;
        }
        return sb.substring(start);
    }
}
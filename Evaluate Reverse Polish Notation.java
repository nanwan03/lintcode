public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        // Write your code here
        if (tokens == null || tokens.length == 0) {
        	return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        String operators = "+-/*";
        for(String str : tokens) {
        	if (!operators.contains(str)) {
        		stack.push(Integer.valueOf(str));
        	} else {
        		int b = stack.pop();
        		int a = stack.pop();
        		if (str.equals("+")) {
        			stack.push(a + b);
        		} else if (str.equals("-")) {
        			stack.push(a - b);
        		} else if (str.equals("*")) {
        			stack.push(a * b);
        		} else {
        			stack.push(a / b);
        		}
        	}
        }
        return stack.pop();
    }
}

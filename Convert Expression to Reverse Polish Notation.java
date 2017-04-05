public class Solution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public ArrayList<String> convertToRPN(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return new ArrayList<String>();
        }
        return getRPN(expression);
    }
    private ArrayList<String> getRPN(String[] expression) {
        ArrayList<String> rpn = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        String ops = "+-*/()";
        for (String str : expression) {
            if (ops.contains(str)) {
                if (stack.isEmpty() || str.equals("(")) {
                    stack.push(str);
                } else if (str.equals(")")) {
                    while (!stack.isEmpty()) {
                        String op = stack.pop();
                        if (op.equals("(")) {
                            break;
                        }
                        rpn.add(op);
                    }
                } else {
                    if (cmp(stack.peek(), str) == 1) {
                        stack.push(str);
                    } else {
                        while (!stack.isEmpty() && cmp(stack.peek(), str) == 0) {
                            rpn.add(stack.pop());
                        }
                        stack.push(str);
                    }
                }
            } else {
                rpn.add(str);
            }
        }
        while (!stack.isEmpty()) {
            rpn.add(stack.pop());
        }
        return rpn;
    }
    private int cmp(String a, String b) {
        String temp1 = "+-(";
        String temp2 = "*/";
        if (temp1.contains(a) && temp2.contains(b)) {
            return 1;
        }
        temp1 = "(";
        temp2 = "+-";
        if (temp1.contains(a) && temp2.contains(b)) {
            return 1;
        }
        return 0;
    }
}
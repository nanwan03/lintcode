public class Solution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        // write your code here
    	if (expression == null || expression.length == 0) {
    		return 0;
    	}
    	String ops = "()+-*/";
    	List<String> rpn = getRPN(expression, ops);
    	return eval(rpn, ops);
    	
    }
    private int eval(List<String> rpn, String ops) {
        if(rpn == null || rpn.size() == 0) {
            return 0;
        }
    	Stack<Integer> stack = new Stack<Integer>();
    	for (String str : rpn) {
    		if (!ops.contains(str)) {
    			stack.push(Integer.parseInt(str));
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
    private List<String> getRPN(String[] expression, String ops) {
    	List<String> rpn = new ArrayList<String>();
    	Stack<String> stack = new Stack<String>();
    	for (String str : expression) {
    		if (str.equals("(") || str.equals(")") || str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
    			if (stack.isEmpty()) {
    				stack.push(str);
    			} else if (str.equals("(")) {
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
    				if (mycmp(stack.peek(), str) == 1) {
    					stack.push(str);
    				} else {
    					while (!stack.isEmpty() && mycmp(stack.peek(), str) == 0) {
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
    private int mycmp(String a, String b) {
    	if(b.equals("(")) {
    		return 1;//左括号直接入栈
    	} else if((b.equals("*") || b.equals("/")) &&(a.equals("+") || a.equals("-") || a.equals("("))) {
    		return 1;//*、/优先级高于+、-、(，入栈
    	} else if((b.equals("+") || b.equals("-")) && (a.equals("("))) {
    		return 1;//+、-优先级高于(，入栈
    	} else {
    		return 0;
    	}
    }
};

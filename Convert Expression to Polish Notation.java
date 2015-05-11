public class Solution {
    /**
     * @param expression: A string array
     * @return: The Polish notation of this expression
     */
    public ArrayList<String> convertToPN(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
    		return new ArrayList<String>();
    	}
    	reverse(expression);
    	String ops = "()+-*/";
    	ArrayList<String> pn = getPN(expression, ops);
    	return pn;
    }
    private void reverse(String[] expression) {
        int left = 0;
        int right = expression.length - 1;
        while (left < right) {
            swap(expression, left++, right--);
        }
    }
    private void swap(String[] expression, int i, int j) {
        String temp = expression[i];
        expression[i] = expression[j];
        expression[j] = temp;
    }
    private ArrayList<String> getPN(String[] expression, String ops) {
    	ArrayList<String> pn = new ArrayList<String>();
    	Stack<String> stack = new Stack<String>();
    	for (String str : expression) {
    		if (str.equals("(") || str.equals(")") || str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
    			if (stack.isEmpty()) {
    				stack.push(str);
    			} else if (str.equals(")")) {
    				stack.push(str);
    			} else if (str.equals("(")) {
    				while (!stack.isEmpty()) {
    					String op = stack.pop();
    					if (op.equals(")")) {
    						break;
    					}
    					pn.add(op);
    				}
    			} else {
    				if (mycmp(stack.peek(), str) == 1) {
    					stack.push(str);
    				} else {
    					while (!stack.isEmpty() && mycmp(stack.peek(), str) == 0) {
    						pn.add(stack.pop());
    					}
    					stack.push(str);
    				}
    			}
    		} else {
    			pn.add(str);
    		}
    	}
    	while (!stack.isEmpty()) {
    		pn.add(stack.pop());
    	}
    	Collections.reverse(pn);
    	return pn;
    }
    private int mycmp(String a, String b) {
    	if(a.equals(")")) {
    		return 1;//右括号直接入栈
    	} else if((b.equals("*") || b.equals("/")) &&(a.equals("+") || a.equals("-") || a.equals(")"))) {
    		return 1;//*、/优先级高于+、-、)，入栈
    	} else if((b.equals("+") || b.equals("-")) && (a.equals(")"))) {
    		return 1;//+、-优先级高于)，入栈
    	} else if ((b.equals("*") || b.equals("/")) &&(a.equals("*") || a.equals("/"))) {
    	    return 1;
    	} else if((b.equals("+") || b.equals("-")) &&(a.equals("+") || a.equals("-"))) {
    	    return 1;
    	} else {
    		return 0;
    	}
    }
}

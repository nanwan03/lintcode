/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
    		return null;
    	}
    	String ops = "()+-*/";
    	List<String> rpn = getRPN(expression, ops);
    	ExpressionTreeNode root = buildTree(rpn, ops);
    	return root;
    }
    private ExpressionTreeNode buildTree(List<String> rpn, String ops) {
        Stack<ExpressionTreeNode> stack = new Stack<ExpressionTreeNode>();
        for (String str : rpn) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                ExpressionTreeNode newNode = new ExpressionTreeNode(str);
                ExpressionTreeNode right = stack.pop();
                ExpressionTreeNode left = stack.pop();
                newNode.left = left;
                newNode.right = right;
                stack.push(newNode);
            } else {
                stack.push(new ExpressionTreeNode(str));
            }
        }
        return stack.isEmpty() ? null : stack.pop();
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
}

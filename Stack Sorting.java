public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        // Write your code here
    	if (stack == null || stack.size() <= 1) {
    		return;
    	}
    	Stack<Integer> helper = new Stack<Integer>();
    	while (stack.size() != 0) {
    		int top = stack.pop();
    		if (helper.size() == 0 || helper.peek() >= top) {
    			helper.push(top);
    		} else {
    			while (helper.size() != 0 && helper.peek() < top) {
    				stack.push(helper.pop());
    			}
    			helper.push(top);
    		}
    	}
    	
    	while (helper.size() != 0) {
    		stack.push(helper.pop());
    	}
    }
}
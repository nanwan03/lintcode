public class Solution {
    
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public Solution() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty() || number <= minStack.peek()) {
            minStack.push(number);
        }
    }

    public int pop() {
        // write your code here
        int temp = stack.pop();
        if (temp == minStack.peek()) {
            minStack.pop();
        }
        return temp;
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}


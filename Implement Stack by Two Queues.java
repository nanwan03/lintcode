class Stack {
    Queue<Integer> queue1 = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();
	List<Queue<Integer>> list = new ArrayList<Queue<Integer>>();
	Stack() {
	    list.add(queue1);
	    list.add(queue2);
	}
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
         if (!list.get(0).isEmpty()) {
	    	list.get(0).offer(x);
	    } else {
	    	list.get(1).offer(x);
	    }
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        int cur = list.get(0).isEmpty() ? 1 : 0;
	    int alter = 1 - cur;
	    while (list.get(cur).size() > 1) {
	    	list.get(alter).add(list.get(cur).poll());
	    }
	    list.get(cur).poll();
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        int ret = 0;
	    int cur = list.get(0).isEmpty() ? 1 : 0;
	    int alter = 1 - cur;
	    while (list.get(cur).size() > 1) {
	    	list.get(alter).add(list.get(cur).poll());
	    }
	    ret = list.get(cur).poll();
	    list.get(alter).offer(ret);
	    return ret;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return queue1.isEmpty() && queue2.isEmpty();
    }    
}
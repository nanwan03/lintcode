class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
        next = null;
    }
}
class Stack {
    // Push a new item into the stack
    private Node head = null;
    public void push(int x) {
        // Write your code here
        Node node = new Node(x);
        node.next = head;
        head = node;
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        head = head.next;
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return head == null;
    }    
}
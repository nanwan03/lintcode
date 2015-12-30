class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
        this.next = null;
    }
}
public class Queue {
    private Node head = null;
    private Node tail = null;
    public Queue() {
        // do initialize if necessary
        head = tail;
    }

    public void enqueue(int item) {
        // Write your code here
        Node node = new Node(item);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = tail;
        }
    }

    public int dequeue() {
        // Write your code here
        if (head == null) {
            return -1;
        }
        int val = head.val;
        head = head.next;
        return val;
    }
}
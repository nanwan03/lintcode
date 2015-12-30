class Node {
    int val;
    Node prev;
    Node next;
    Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
public class Dequeue {
    private Node head = null;
    private Node tail = null;
    public Dequeue() {
        // do initialize if necessary
        head = tail;
    }

    public void push_front(int item) {
        // Write your code here
        Node node = new Node(item);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    public void push_back(int item) {
        // Write your code here
        Node node = new Node(item);
        if (tail != null) {
            tail.next = node;
        }
        node.prev = tail;
        tail = node;
        if (head == null) {
            head = tail;
        }
    }

    public int pop_front() {
        // Write your code here
        if (head == null) {
            return -1;
        }
        Node cur = head;
        
        int val = cur.val;
        if (cur == tail) {
            tail = tail.next;
        }
        head = head.next;
        
        cur.next = null;
        if (head != null) {
            head.prev = null;
        }
        
        return val;
    }

    public int pop_back() {
        // Write your code here
        if (tail == null) {
            return -1;
        }
        Node cur = tail;
        
        int val = cur.val;
        if (cur == head) {
            head = head.prev;
        }
        tail = tail.prev;
        
        cur.prev = null;
        if (tail != null) {
            tail.next = null;
        }
        
        return val;
    }
}
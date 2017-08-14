public class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
    private int capacity;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    // @param capacity, an integer
    public LRUCache(int capacity) {
        // write your code here
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        removeNode(n);
        moveToTail(n);
        return n.value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if (get(key) != -1)  {
            map.get(key).value = value;
            return;
        }
        if (map.size() == capacity) {
            map.remove(head.next.key);
            removeNode(head.next);
        }
        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }
    private void moveToTail(Node n) {
        n.next = tail;
        n.prev = tail.prev;
        tail.prev.next = n;
        tail.prev = n;
    }
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
}
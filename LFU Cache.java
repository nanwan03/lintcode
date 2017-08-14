public class LFUCache {
    private class Node {
        int freq;
        Set<Integer> keys = new LinkedHashSet<Integer>();
        Node prev;
        Node next;
        Node(Node prev, Node next, int freq, int key) {
            this.prev = prev;
            this.next = next;
            this.freq = freq;
            this.keys.add(key);
        }
    }
    private int capacity;
    private Node head = new Node(null, null, 0, -1);
    private Node tail = new Node(null, null, 0, -1);
    private Map<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
    private Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();
    // @param capacity, an integer
    public LFUCache(int capacity) {
        // Write your code here
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // Write your code here
        if (get(key) == -1) {
            if (valueMap.size() == capacity) {
                if (head.next == tail) {
                    return;
                }
                int oldest = head.next.keys.iterator().next();
                valueMap.remove(oldest);
                nodeMap.remove(oldest);
                removeKey(oldest, head.next);
            }
            addNode(head, head.next, 1, key);
        }
        valueMap.put(key, value);
        
    }

    public int get(int key) {
        // Write your code here
        if (!valueMap.containsKey(key)) {
            return -1;
        }
        Node node = nodeMap.get(key);
        addNode(node, node.next, node.freq + 1, key);
        removeKey(key, node);
        return valueMap.get(key);
    }
    private void addNode(Node prev, Node next, int freq, int key) {
        if (next.freq == prev.freq + 1) {
            next.keys.add(key);
        } else {
            Node insert = new Node(prev, next, freq, key);
            insert.next.prev = insert;
            insert.prev.next = insert;
        }
        nodeMap.put(key, prev.next);
    }
    private void removeKey(int key, Node node) {
        node.keys.remove(key);
        if (node.keys.isEmpty()) {
            node.next.prev = node.prev;
            node.prev.next = node.next;   
        }
    }
}
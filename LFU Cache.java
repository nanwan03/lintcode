public class LFUCache {
    class Node {
        public Node prev, next;
        public final int freq;
        public LinkedHashSet<Integer> keys = new LinkedHashSet<Integer>();

        public Node(Node prev, Node next, int freq, int key) {
            this.prev = prev;
            this.next = next;
            this.freq = freq;
            keys.add(key);
        }
    }
    
    private Node head = null;
    private final int capacity;
    private Map<Integer, Integer> valueMap;
    private Map<Integer, Node> nodeMap;
    // @param capacity, an integer
    public LFUCache(int capacity) {
        // Write your code here
        this.capacity = capacity;
        valueMap = new HashMap<Integer, Integer>();
        nodeMap = new HashMap<Integer, Node>();
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // Write your code here
        if (this.capacity == 0) {
            return;
        }
        if (valueMap.containsKey(key)) {
            updateFreq(key);
        } else {
            if (valueMap.size() == this.capacity) {
                evict();
            }
            addNode(key);
        }
        valueMap.put(key, value);
    }

    public int get(int key) {
        // Write your code here
        if (valueMap.containsKey(key)) {
            updateFreq(key);
        }
        if (valueMap.containsKey(key)) {
            return valueMap.get(key);
        } else {
            return -1;
        }
    }
    
    private void updateFreq(int key) {
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        if (node.next == null) {
            node.next = new Node(node, null, 1 + node.freq, key);
        } else if (node.next.freq == node.freq + 1) {
            node.next.keys.add(key);
        } else {
            Node tmp = new Node(node, node.next, node.freq + 1, key);
            node.next.prev = tmp;
            node.next = tmp;
        }
        nodeMap.put(key, node.next);
        if (node.keys.isEmpty()) {
            removeNode(node);
        }
    }

    private void removeNode(Node node) {
        if (head == node) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }
    
    private void addNode(int key) {
        if (head == null) {
            head = new Node(null, null, 1, key);
        } else if (head.freq == 1) {
            head.keys.add(key);
        } else {
            Node tmp = new Node(null, head, 1, key);
            head.prev = tmp;
            head = tmp;
        }
        nodeMap.put(key, head);
    }

    private void evict() {
        if (head == null) {
            return;
        }
        int oldest = head.keys.iterator().next();
        head.keys.remove(oldest);
        if (head.keys.isEmpty()) {
            removeNode(head);
        }
        nodeMap.remove(oldest);
        valueMap.remove(oldest);
    }
}
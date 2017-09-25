public class Memcache {
    private class Node {
        public int value;
        public int expired;
        public Node(int value, int expired) {
            this.value = value;
            this.expired = expired;
        }
    }
    Map<Integer, Node> client;
    public Memcache() {
        // do intialization if necessary
        client = new HashMap<Integer, Node>();
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: An integer
     */
    public int get(int curtTime, int key) {
        // write your code here
        if (client.containsKey(key)) {
            Node n = client.get(key);
            if (n.expired >= curtTime || n.expired == -1) {
                return n.value;
            }
        }
        return Integer.MAX_VALUE;

    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param value: An integer
     * @param ttl: An integer
     * @return: nothing
     */
    public void set(int curtTime, int key, int value, int ttl) {
        // write your code here
        client.put(key, new Node(value, ttl == 0 ? -1 : curtTime + ttl - 1));
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: nothing
     */
    public void delete(int curtTime, int key) {
        // write your code here
        if (client.containsKey(key)) {
            client.remove(key);
        }
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int incr(int curtTime, int key, int delta) {
        // write your code here
        if (get(curtTime, key) == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        client.get(key).value += delta;
        return client.get(key).value;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int decr(int curtTime, int key, int delta) {
        // write your code here
        if (get(curtTime, key) == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        client.get(key).value -= delta;
        return client.get(key).value;
    }
}
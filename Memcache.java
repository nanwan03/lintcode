public class Memcache {
    private class Resource {
        public int value;
        public int expired;
        public Resource(int value, int expired) {
            this.value = value;
            this.expired = expired;
        }
    }
    Map<Integer, Resource> client = null;
    public Memcache() {
        // do intialization if necessary
        client = new HashMap<Integer, Resource>();
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: An integer
     */
    public int get(int curtTime, int key) {
        // write your code here
        if (!client.containsKey(key))
            return Integer.MAX_VALUE;

        Resource res = client.get(key);
        if (res.expired >= curtTime || res.expired == -1)
            return res.value;
        else
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
        int expired;
        if (ttl == 0)
            expired = -1;
        else
            expired = curtTime + ttl - 1;
        client.put(key, new Resource(value, expired));
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: nothing
     */
    public void delete(int curtTime, int key) {
        // write your code here
        if (!client.containsKey(key))
            return;
        client.remove(key);
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int incr(int curtTime, int key, int delta) {
        // write your code here
        if (get(curtTime, key) == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
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
        if (get(curtTime, key) == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        client.get(key).value -= delta;
        return client.get(key).value;
    }
}
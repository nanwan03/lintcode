public class Solution {
    int size;
    LinkedHashMap<Integer, Integer> cache;
    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
        size = capacity;
        cache = new LinkedHashMap<Integer, Integer>();
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if(!cache.containsKey(key)) return -1;
        int val = cache.remove(key);
        cache.put(key, val); // the feature of linkedhashmap
        return val;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if(cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            return;
        }
        if(cache.size()==size) { // find the least visited entry and remove
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
        cache.put(key, value);
    }
}

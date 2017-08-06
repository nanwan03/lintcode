public class RandomizedSet {
    List<Integer> lists = new ArrayList<Integer>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Random r = new Random();
    public RandomizedSet() {
        // do initialize if necessary
    }
    
    // Inserts a value to the set
    // Returns true if the set did not already contain the specified element or false
    public boolean insert(int val) {
        // Write your code here
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, lists.size());
        lists.add(val);
        return true;
    }
    
    // Removes a value from the set
    // Return true if the set contained the specified element or false
    public boolean remove(int val) {
        // Write your code here
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        if (index != lists.size() - 1) {
            int i = lists.get(lists.size() - 1);
            lists.set(index, i);
            map.put(i, index);
        }
        map.remove(val);
        lists.remove(lists.size() - 1);
        return true;
    }
    
    // Get a random element from the set
    public int getRandom() {
        // Write your code here
        return lists.get(r.nextInt(lists.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */
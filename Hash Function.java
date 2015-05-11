class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        if (key == null || key.length == 0) {
            return 0;
        }
        long hash = 0;
        for (char c : key) {
            hash = (hash * 33 + (long)c) % HASH_SIZE;
        }
        return (int)(hash % HASH_SIZE);
    }
};

class HashFunction {
    public int cap;
    public int seed;
    public HashFunction(int cap, int seed) {
        this.cap = cap;
        this.seed = seed;
    }
    public int hash(String value) {
        int rst = 0;
        for (int i = 0; i < value.length(); ++i) {
            rst += seed * rst + value.charAt(i);
            rst %= cap;
        }
        return rst;
    }
}
public class CountingBloomFilter {
    public int[] bits;
    public int k;
    public List<HashFunction> hashFunc;
    private final int M = 100000;
    /*
    * @param k: An integer
    */public CountingBloomFilter(int k) {
        // do intialization if necessary
        this.k = k;
        hashFunc = new ArrayList<HashFunction>();
        for (int i = 0; i < k; ++i) {
            hashFunc.add(new HashFunction(M + i, 2 * i + 3));
        }
        bits = new int[M + k];
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        // write your code here
        for (int i = 0; i < k; ++i) {
            bits[getPosition(i, word)] += 1;
        }
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void remove(String word) {
        // write your code here
        for (int i = 0; i < k; ++i) {
            bits[getPosition(i, word)] -= 1;
        }
    }

    /*
     * @param word: A string
     * @return: True if contains word
     */
    public boolean contains(String word) {
        // write your code here
        for (int i = 0; i < k; ++i) {
            if (bits[getPosition(i, word)] <= 0) {
                return false;
            }
        }
        return true;
    }
    
    private int getPosition(int index, String word) {
        return hashFunc.get(index).hash(word);
    }
}
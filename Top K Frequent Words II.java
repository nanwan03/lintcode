public class TopK {
    private Map<String, Integer> words = new HashMap<String, Integer>();
    private TreeSet<String> topk = null;
    private int k;
    private class Cmp implements Comparator<String> {
    	public int compare(String a, String b) {
    		int countA = words.get(a);
    		int countB = words.get(b);
    		return countA == countB ? a.compareTo(b) : countB - countA;
    	}
    }
    /*
    * @param k: An integer
    */public TopK(int k) {
        // do intialization if necessary
        this.k = k;
        words = new HashMap<String, Integer>();
        topk = new TreeSet<String>(new Cmp());
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        // write your code here
        if (words.containsKey(word)) {
            if (topk.contains(word)) {
                topk.remove(word);
            }
            words.put(word, words.get(word) + 1);
        } else {
            words.put(word, 1);
        }
        topk.add(word);
        if (topk.size() > k) {
            topk.pollLast();
        }
    }

    /*
     * @return: the current top k frequent words.
     */
    public List<String> topk() {
        // write your code here
        return Arrays.asList(topk.toArray(new String[topk.size()]));
    }
}
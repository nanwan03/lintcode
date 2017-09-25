public class Solution {
    /*
     * @param n: a positive integer
     * @param k: a positive integer
     * @return: a Solution object
     */
    private int n;
    private int k;
    private Map<Integer, Integer> machines;
    public Solution(int n, int k) {
        this.n = n;
        this.k = k;
        this.machines = new HashMap<Integer, Integer>();
    }
    public static Solution create(int n, int k) {
        // Write your code here
        return new Solution(n, k);
    }

    /*
     * @param machine_id: An integer
     * @return: a list of shard ids
     */
    public List<Integer> addMachine(int machine_id) {
        // write your code here
        Random r = new Random();
        List<Integer> randomL = new ArrayList<Integer>();
        for (int i = 0; i < k; ++i) {
            int index = r.nextInt(n);
            while (machines.containsKey(index)) {
                index = r.nextInt(n);
            }
            machines.put(index, machine_id);
            randomL.add(index);
        }
        Collections.sort(randomL);
        return randomL;
    }

    /*
     * @param hashcode: An integer
     * @return: A machine id
     */
    public int getMachineIdByHashCode(int hashcode) {
        // write your code here
        while (!machines.containsKey(hashcode)) {
            hashcode = (++hashcode) % n;
        }
        return machines.get(hashcode);
    }
}
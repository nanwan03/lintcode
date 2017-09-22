public class Solution {
    /*
     * @param n: a positive integer
     * @param k: a positive integer
     * @return: a Solution object
     */
    public int n, k;
    public Set<Integer> ids = null;
    public Map<Integer, List<Integer>> machines = null;
    public static Solution create(int n, int k) {
        // Write your code here
        Solution solution = new Solution();
        solution.n = n;
        solution.k = k;
        solution.ids = new TreeSet<Integer>();
        solution.machines = new HashMap<Integer, List<Integer>>();
        return solution;
    }

    /*
     * @param machine_id: An integer
     * @return: a list of shard ids
     */
    public List<Integer> addMachine(int machine_id) {
        // write your code here
        Random ra =new Random();
        List<Integer> random_nums = new ArrayList<Integer>();
        for (int i = 0; i < k; ++i) {
            int index = ra.nextInt(n);
            while (ids.contains(index))
                index = ra.nextInt(n);
            ids.add(index);
            random_nums.add(index);
        }

        Collections.sort(random_nums);
        machines.put(machine_id, random_nums);
        return random_nums;
    }

    /*
     * @param hashcode: An integer
     * @return: A machine id
     */
    public int getMachineIdByHashCode(int hashcode) {
        // write your code here
        int distance = n + 1;
        int machine_id = 0;
        for (Map.Entry<Integer, List<Integer>> entry : machines.entrySet()) {
            int key = entry.getKey();
            List<Integer> random_nums = entry.getValue();
            for (Integer num : random_nums) {
                int d = num - hashcode;
                if (d < 0)
                    d += n;
                if (d < distance) {
                    distance = d;
                    machine_id = key;
                }
            }
        }
        return machine_id;
    }
}
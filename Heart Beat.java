public class HeartBeat {
    public Map<String, Integer> slaves_ip_list;
    public int k;
    public HeartBeat() {
        // do intialization if necessary
        slaves_ip_list = new HashMap<String, Integer>();
    }

    /*
     * @param slaves_ip_list: a list of slaves'ip addresses
     * @param k: An integer
     * @return: nothing
     */
    public void initialize(List<String> slaves_ip_list, int k) {
        // write your code here
        this.k = k;
        for (String ip : slaves_ip_list)
            this.slaves_ip_list.put(ip, 0);
    }

    /*
     * @param timestamp: current timestamp in seconds
     * @param slave_ip: the ip address of the slave server
     * @return: nothing
     */
    public void ping(int timestamp, String slave_ip) {
        // write your code here
        if (!slaves_ip_list.containsKey(slave_ip))
            return;
        
        slaves_ip_list.put(slave_ip, timestamp);
    }

    /*
     * @param timestamp: current timestamp in seconds
     * @return: a list of slaves'ip addresses that died
     */
    public List<String> getDiedSlaves(int timestamp) {
        // write your code here
        List<String> results = new ArrayList<String>();
        
        Iterator iter = slaves_ip_list.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            String ip = (String) entry.getKey();
            int time = (Integer) entry.getValue();
            if (time <= timestamp - 2 * k)
                results.add(ip);
        }
        return results;
    }
}
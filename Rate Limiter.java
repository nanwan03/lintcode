public class Solution {
    /*
     * @param timestamp: the current timestamp
     * @param event: the string to distinct different event
     * @param rate: the format is [integer]/[s/m/h/d]
     * @param increment: whether we should increase the counter
     * @return: true or false to indicate the event is limited or not
     */
    private Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    private Map<String, Integer> durationMap = new HashMap<String, Integer>();
    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        // write your code here
        durationMap.put("s", 1);
        durationMap.put("m", 60);
        durationMap.put("h", 3600);
        durationMap.put("d", 86400);
        
        int index = rate.indexOf("/");
        int limit = Integer.parseInt(rate.substring(0, index));
        int duration = durationMap.get(rate.substring(index + 1));
        int start = timestamp - duration + 1;
        if (!map.containsKey(event)) {
            map.put(event, new ArrayList<Integer>());
        }
        int count = getCount(map.get(event), start);
        if (increment && count < limit) {
            map.get(event).add(timestamp);
        }
        return count >= limit;
    }
    private int getCount(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (list.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return list.size() - left;
    }
}
public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
        List<List<String>> rst = new ArrayList<List<String>>();
        if (dict == null) {
            return rst;
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put(start, new ArrayList<String>());
        map.put(end, new ArrayList<String>());
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }
        List<String> path = new ArrayList<String>();
        path.add(start);
        List<String> currentLevel = new ArrayList<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            currentLevel.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                dict.remove(str);
                currentLevel.add(str);
            }
            for (String s : currentLevel) {
                for (int i = 0; i < s.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == s.charAt(i)) {
                            continue;
                        }
                        String temp = replace(s, i, c);
                        if (dict.contains(temp)) {
                            if (!queue.contains(temp)) {
                                queue.offer(temp);
                            }
                            map.get(s).add(temp);
                        }
                    }
                }
            }
            if (queue.contains(end)) {
                break;
            }
        }
        helper(start, end, map, path, rst);
        return rst;
    }
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    private void helper(String start, String end, Map<String, List<String>> map, List<String> path, List<List<String>> rst) {
        List<String> list = map.get(start);
        if (start.equals(end)) {
            rst.add(new ArrayList<String>(path));
            return;
        }
        for (String s : list) {
            path.add(s);
            helper(s, end, map, path, rst);
            path.remove(path.size() - 1);
        }
    }
}

public class Solution {
    private static class TrieNode {
        Map<Character, TrieNode> children = new TreeMap<Character, TrieNode>();
        boolean isEnd = false;
        public TrieNode() {
            
        }
    }
    private TrieNode root = new TrieNode();
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    /*
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> rst = new ArrayList<String>();
        if (board == null || board.length == 0 || words.size() == 0) {
            return rst;
        }
        for (String str : words) {
            insert(str);
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                helper(rst, new StringBuilder(), root, board, i, j, row, col);
            }
        }
        return rst;
    }
    private void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }
    private void helper(List<String> rst, StringBuilder sb, TrieNode cur, char[][] board, int x, int y, int row, int col) {
        if (cur.isEnd) {
            if (!rst.contains(sb.toString())) {
                rst.add(sb.toString());
            }
        }
        if (x < 0 || x >= row || y < 0 || y >= col || cur.children.isEmpty() || !cur.children.containsKey(board[x][y])) {
            return;
        }
        char c = board[x][y];
        board[x][y] = '.';
        sb.append(c);
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            helper(rst, sb, cur.children.get(c), board, nx, ny, row, col);
        } 
        sb.deleteCharAt(sb.length() - 1);
        board[x][y] = c;
    }
}
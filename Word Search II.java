public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    private class Node {
        Node[] next;
        boolean end;
        Node() {
            next = new Node[26];
            end = false;
        }
        public void insert(String str) {
            Node node = this;
            for (char c : str.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new Node();
                }
                node = node.next[c - 'a'];
            }
            node.end = true;
        }
    }
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> rst = new ArrayList<String>();
        if (board == null || board.length == 0) {
            return rst;
        }
        Node node = new Node();
        for (String str : words) {
            node.insert(str);
        }
        int row = board.length;
        int col = board[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = board[i][j];
                if (node.next[c - 'a'] != null) {
                    BFS(node, board, i, j, sb, rst);
                }
            }
        }
        return rst;
    }
    private void BFS(Node node, char[][] board, int i, int j, StringBuilder sb, List<String> rst) {
        int row = board.length;
        int col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] == '.' || node.next[board[i][j] - 'a'] == null) {
            return;
        }
        char c = board[i][j];
        sb.append(c);
        board[i][j] = '.';
        node = node.next[c - 'a'];
        if (node.end == true) {
            if (!rst.contains(sb.toString())) {
                rst.add(sb.toString());
            }
        }
        BFS(node, board, i + 1, j, sb, rst);
        BFS(node, board, i - 1, j, sb, rst);
        BFS(node, board, i, j + 1, sb, rst);
        BFS(node, board, i, j - 1, sb, rst);
        board[i][j] = c;
        sb.deleteCharAt(sb.length() - 1);
    }
}

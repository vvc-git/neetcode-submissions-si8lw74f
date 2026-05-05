class Solution {

    int ROWS, COLS;
    char[][] board;
    boolean[][] visited;
    Set<String> result;
    PrefixTree pf;


    class NodeTree {
        Character val;
        Map<Character, NodeTree> next = new HashMap<>();
        Boolean isEnd;

        NodeTree(Character val) {
            this.val = val;
            this.isEnd = false;
        }
    }

    class PrefixTree {
        NodeTree root = new NodeTree('-');

        public void insert(String word) {
            NodeTree node = this.root;

            for (Character c : word.toCharArray()) {
                node.next.putIfAbsent(c, new NodeTree(c));
                node = node.next.get(c);
            }
            node.isEnd = true;
        }
    }

    public void dfs(NodeTree curr, int nextRow, int nextCol, String word) {
        // Check if we are in bounds
        // Check if we already visited
        // Check if curr has nodes in our tree
        if (nextRow < 0 || nextCol < 0 || nextRow >= ROWS || nextCol >= COLS 
            || visited[nextRow][nextCol] 
            || !curr.next.containsKey(board[nextRow][nextCol])) {
                return;
        }

        visited[nextRow][nextCol] = true;
        word += board[nextRow][nextCol];
        curr = curr.next.get(board[nextRow][nextCol]);
        if (curr.isEnd) {
            result.add(word);
        }

        dfs(curr, nextRow, nextCol + 1, word);
        dfs(curr, nextRow, nextCol - 1, word);
        dfs(curr, nextRow + 1, nextCol, word);
        dfs(curr, nextRow - 1, nextCol, word);

        visited[nextRow][nextCol] = false;

    }


    public List<String> findWords(char[][] board, String[] words) {

        PrefixTree pf = new PrefixTree();
        this.result = new HashSet<>();
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;
        this.visited = new boolean[ROWS][COLS];

        for (String w : words) {
            pf.insert(w);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(pf.root, r, c, "");
            }
        }
        return new ArrayList(this.result);
    }
}

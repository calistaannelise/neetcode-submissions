class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean ret = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                ret = ret || dfs(board, visited, word, 0, i, j);
            }
        }
        return ret;
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int i, int row, int col) {
        if (i == word.length()) {
            return true;
        } else if (row >= board.length || col >= board[0].length || row < 0 || col < 0 || board[row][col] != word.charAt(i) || visited[row][col]) {
            return false;
        } else {
            visited[row][col] = true;
            boolean ret = dfs(board, visited, word, i+1, row+1, col) || dfs(board, visited, word, i+1, row, col+1) || dfs(board, visited, word, i+1, row-1, col) || dfs(board, visited, word, i+1, row, col-1);
            visited[row][col] = false;
            return ret;
        }
    }
}

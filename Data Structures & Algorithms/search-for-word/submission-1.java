class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word(board, visited, word, 0, i, j)) {
                    return true;
                } 
            }
        }
        return false;
    }

    public boolean word(char[][] board, boolean[][] visited, String word, int i, int row, int col) {
        if (i == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(i) || visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        boolean ret = word(board, visited, word, i+1, row+1, col) || word(board, visited, word, i+1, row, col+1) || word(board, visited, word, i+1, row-1, col) || word(board, visited, word, i+1, row, col-1);
        visited[row][col] = false;
        return ret;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
       int maxArea = 0;
       boolean[][] visited = new boolean[grid.length][grid[0].length];
       
       for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (!visited[i][j]) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, visited, i, j));
                }
            }
        }
       }
       return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]) {
            return 0;
        } 
        visited[row][col] = true;
        if (grid[row][col] == 1) {
            return 1 + dfs(grid, visited, row+1, col) + dfs(grid, visited, row, col+1) + dfs(grid, visited, row-1, col) + dfs(grid, visited, row, col-1);
        } else {
            return 0;
        }
    }
}







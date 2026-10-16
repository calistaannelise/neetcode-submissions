class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int j = 0; j < heights[0].length; j++) {
            dfs(heights, pacific, 0, j, -1);
            dfs(heights, atlantic, heights.length - 1, j, -1);
        }

        for (int i = 0; i < heights.length; i++) {
            dfs(heights, pacific, i, 0, -1);
            dfs(heights, atlantic, i, heights[0].length - 1, -1);
        }

        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ret.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }
        return ret;
    }

    public void dfs(int[][] heights, boolean[][] reachable, int i, int j, int prev) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || reachable[i][j]) {
            return;
        }
        
        int curr = heights[i][j];
        if (prev <= curr) {
            reachable[i][j] = true;
            prev = curr;
            dfs(heights, reachable, i+1, j, prev);
            dfs(heights, reachable, i, j+1, prev);
            dfs(heights, reachable, i-1, j, prev);
            dfs(heights, reachable, i, j-1, prev);
        } else {
            return;
        }
    }
}

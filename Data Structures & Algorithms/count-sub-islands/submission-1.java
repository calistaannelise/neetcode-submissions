class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // dfs to mark all the islands
        // once find a land thats not marked, add to the total number of sub islands
        // check from grid 2, while marking the islands, simultaneously check with grid 1. If there's a square that's not an island in grid1, don't add to the total number but still check through it
        boolean[][] visited = new boolean[grid2.length][grid2[0].length];
        Deque<int[]> queue = new ArrayDeque<>();
        int ret = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    boolean ok = true;
                    queue.add(new int[]{i, j});
                    
                    while(!queue.isEmpty()) {
                        int[] pos = queue.pollFirst();
                        int x = pos[0];
                        int y = pos[1];
                        if (grid2[x][y] == 1 && !visited[x][y]) {
                            if (grid1[x][y] == 0 && grid2[x][y] == 1) {
                                ok = false;
                            }
                            visited[x][y] = true;
                            if (x + 1 < grid2.length && !visited[x+1][y]) {
                                queue.addLast(new int[]{x+1, y});
                            }
                            if (y + 1 < grid2[0].length && !visited[x][y+1]) {
                                queue.addLast(new int[]{x, y+1});
                            }
                            if (x - 1 >= 0 && !visited[x-1][y]) {
                                queue.addLast(new int[]{x-1, y});
                            }
                            if (y - 1 >= 0 && !visited[x][y-1]) {
                                queue.addLast(new int[]{x, y-1});
                            }
                        }
                    }

                    if (ok) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }
}

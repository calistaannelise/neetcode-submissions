class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length >= n) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];

        dfs(map, visited, 0);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public void dfs(Map<Integer, List<Integer>> map, boolean[] visited, int node) {
        if (!visited[node]) {
            visited[node] = true;
            for (int n : map.get(node)) {
                dfs(map, visited, n);
            }
        }
    }
}

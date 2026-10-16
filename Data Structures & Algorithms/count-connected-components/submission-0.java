class Solution {
    public int countComponents(int n, int[][] edges) {
        int ret = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ret++;
                dfs(map, visited, i);
            }
        }
        return ret;
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

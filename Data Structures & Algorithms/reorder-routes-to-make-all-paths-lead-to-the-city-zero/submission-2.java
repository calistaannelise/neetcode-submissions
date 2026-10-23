class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] adjList = new List[n];
        int change = 0;
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] node : connections) {
            adjList[node[0]].add(new int[]{node[1], 1}); // 1 means [i] is the head
            adjList[node[1]].add(new int[]{node[0], 0}); // 0 means [i] is the tail in the pair
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            List<int[]> neighbors = adjList[curr];
            for (int[] ne : neighbors) {
                if (!visited[ne[0]]) { // swap, since curr needs to be the tail (pointed to)
                    if (ne[1] == 1) {
                        change++;
                    }
                    visited[ne[0]] = true;
                    queue.add(ne[0]);
                }
            }
        }
        return change;
    }
}

class Solution {
    public int[] eventualSafeNodes(int[][] graph) {
        // use a visited array
        // when traversing through a node's neighbours, if from the node we go to a visited node, there's a cycle, so every node in the path is not safe
        // nodes without neibours are always safe
        PriorityQueue<Integer> safe = new PriorityQueue<>();
        List<Integer>[] adjList = new List[graph.length];
        int[] outdegree = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            int[] path = graph[i];
            if (path.length == 0) {
                safe.add(i);
            } else {
                for (int n : path) {
                    adjList[n].add(i);
                    outdegree[i]++;
                }
            }
        }

        // traverse backwards from terminal node
        Queue<Integer> queue = new LinkedList<>();
        for (int n : safe) {
            queue.add(n);
        }
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            List<Integer> ne = adjList[curr];
            for (int neigh : ne) {
                outdegree[neigh]--;
                if (outdegree[neigh] == 0) {
                    safe.add(neigh);
                    queue.add(neigh);
                }
            }
        }
        int[] ret = new int[safe.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = safe.remove();
        }
        return ret;
    }
}

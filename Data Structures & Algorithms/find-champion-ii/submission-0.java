class Solution {
    public int findChampion(int n, int[][] edges) {
        // reverse the arrow
        // a node that has no neighbors (points to nothing) is strongest
        // count how many strongest and keep track
        List<Integer>[] adjList = new List[n];
        int strongest = -1;
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] node : edges) {
            int a = node[1];
            int b = node[0]; // a -> b (a weaker than b)
            adjList[a].add(b);
        }

        for (int i = 0; i < adjList.length; i++) {
            if (adjList[i].isEmpty()) {
                if (strongest == -1) {
                    strongest = i;
                } else {
                    return -1;
                }
            }
        }
        return strongest;
    }
}

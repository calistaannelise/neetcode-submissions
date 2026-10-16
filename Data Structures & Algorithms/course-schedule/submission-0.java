class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, map, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int i, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[i]) {
            return false;
        } 
        if (map.get(i).isEmpty()) { // no prereq
            return true;
        }

        visited[i] = true;
        for (int prereq : map.get(i)) {
            if (!dfs(prereq, map, visited)) {
                return false;
            }
        }
        visited[i] = false;
        map.put(i, new ArrayList<>());
        return true;
    }
}


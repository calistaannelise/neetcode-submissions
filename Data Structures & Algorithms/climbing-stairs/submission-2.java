class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return dfs(n, 0);
    }

    public int dfs(int target, int curr) {
        if (curr == target) {
            return 1;
        }
        if (curr > target) {
            return 0;
        }
        if (cache[curr] != -1) {
            return cache[curr];
        }
        cache[curr] = dfs(target, curr + 1) + dfs(target, curr+2);
        return cache[curr];
    }
}

class Solution {
    int[] cache;
    public int rob(int[] nums) {
        cache = new int[nums.length];
        return Math.max(nums[0] + dfs(nums, 2), dfs(nums, 1));
    }

    public int dfs(int[] nums, int house) {
        if (house >= nums.length) {
            return 0;
        }
        if (cache[house] != 0) {
            return cache[house];
        }
        cache[house] = Math.max(nums[house] + dfs(nums, house + 2), dfs(nums, house + 1));
        return cache[house];
    }
}

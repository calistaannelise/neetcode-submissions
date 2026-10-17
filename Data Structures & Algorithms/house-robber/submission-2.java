class Solution {
    int[] cache;
    public int rob(int[] nums) {
        cache = new int[nums.length];
        return Math.max(dfs(nums, 1), dfs(nums, 0));
    }

    public int dfs(int[] nums, int house) {
        if (house >= nums.length) {
            return 0;
        }
        if (cache[house] != 0) {
            return cache[house];
        }
        cache[house] = nums[house] + Math.max(dfs(nums, house + 2), dfs(nums, house + 3));
        return cache[house];
    }
}
